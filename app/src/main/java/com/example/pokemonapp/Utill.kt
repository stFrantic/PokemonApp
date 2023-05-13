package com.example.pokemonapp

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.pokemonapp.model.Type
import java.util.*

const val POKEMON_KEY = "pokemon_url"

fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).into(this)
}

fun typeToString(_list: List<Type>): String {
    var result = ""
    for (i in _list.indices) {
        result += if (i != _list.size - 1)
            "${_list[i].type.name.toUpCase()}, "
        else "${_list[i].type.name.toUpCase()}."
    }
    return result
}

fun String.toUpCase() =
    this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }