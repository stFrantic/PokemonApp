package com.example.pokemonapp.model

import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity (tableName = "pokemonDB")
data class Pokemon(
    @PrimaryKey
    @ColumnInfo(name = "key")
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String = "",
    @ColumnInfo(name = "height")
    val height: Int = 0,
    @ColumnInfo(name = "weight")
    val weight: Int = 0,
    @Embedded
    val sprites: Sprites = Sprites(),

    @TypeConverters(DataTypeConverter::class)
    val types: List<Type> = listOf()
)

data class Sprites(
    val front_default: String = ""
)

data class Type(
    val slot: Int = 0,
    val type: TypeX = TypeX()
)

data class TypeX(
    val name: String = ""
)

class DataTypeConverter {
    @TypeConverter
    fun StringToListType(string: String): List<Type> {
        if (string.isBlank()) return listOf()
        val listType = object: TypeToken<List<Type>>(){}.type
        return Gson().fromJson(string, listType)
    }

    @TypeConverter
    fun ListTypeToString(list: List<Type>): String {
        return Gson().toJson(list)
    }
}