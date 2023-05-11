package com.example.pokemonapp.ui.info

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.model.Pokemon
import com.example.pokemonapp.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    val data = MutableLiveData<Pokemon>()

    fun getInfo(id: String) {
        viewModelScope.launch {
            val result = repository.getPokemon(id)
            result.apply {
                if (isSuccessful)
                    data.postValue(result.body())
            }
        }
    }
}
