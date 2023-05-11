package com.example.pokemonapp.ui

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokemonapp.model.Result
import com.example.pokemonapp.repository.PokemonRepository
import java.lang.Exception
import javax.inject.Inject

class PokemonDataSource @Inject constructor(
    private val repository: PokemonRepository
) : PagingSource<Int, Result>() {

    private var totalPages = 0

      override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPageNumber = params.key ?: 0
            val response = repository.getPokemons(nextPageNumber.toString())
            totalPages = response.body()?.count ?: 0
            if (totalPages < nextPageNumber + 20) {
                LoadResult.Page(
                    data = response.body()?.data ?: arrayListOf(),
                    prevKey = null,
                    nextKey = null
                )
            } else {
                LoadResult.Page(
                    data = response.body()?.data ?: arrayListOf(),
                    prevKey = null,
                    nextKey = nextPageNumber + 20
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(20) ?: anchorPage?.nextKey?.minus(20)
        }
    }
}