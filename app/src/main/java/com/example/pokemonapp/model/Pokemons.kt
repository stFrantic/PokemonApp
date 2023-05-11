package com.example.pokemonapp.model

import com.google.gson.annotations.SerializedName

data class Pokemons(
    val count: Int,
    val next: String,
    val previous: Any,
    @SerializedName("results")
    val data: List<Result>
)

data class Result(
    val name: String,
    val url: String
)