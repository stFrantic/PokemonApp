package com.example.pokemonapp.model

data class Pokemon(
    val height: Int = 0,
    val id: Int = 0,
    val name: String = "",
    val sprites: Sprites = Sprites() ,
    val types: List<Type> = listOf(),
    val weight: Int = 0
)
data class Sprites(
    val front_default : String = ""
)
data class Type(
    val slot: Int = 0,
    val type : TypeX = TypeX()
)
data class TypeX(
    val name : String = ""
)