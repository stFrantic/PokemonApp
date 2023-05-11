package com.example.pokemonapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: PokemonDataSource
) : ViewModel() {

    val result = Pager(PagingConfig(20), 1) {
        dataSource
    }.flow.cachedIn(viewModelScope)

}