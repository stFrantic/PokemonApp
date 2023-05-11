package com.example.pokemonapp.network.api

import com.example.pokemonapp.model.Pokemons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getList(
        @Query("offset") offset: String? = null
    ): Response<Pokemons>


}