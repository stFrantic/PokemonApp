package com.example.pokemonapp.repository

import com.example.pokemonapp.network.api.PokemonApiService
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApiService: PokemonApiService) {


    suspend fun getPokemons(offset: String) = pokemonApiService.getList(offset)

    suspend fun getPokemon(id: String) = pokemonApiService.getPokemon(id)
}