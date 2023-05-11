package com.example.pokemonapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pokemonapp.ui.PokemonDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val dataSource: PokemonDataSource
) : ViewModel() {

    val result = Pager(PagingConfig(20), 0) {
        dataSource
    }.flow.cachedIn(viewModelScope)

}