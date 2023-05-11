package com.example.pokemonapp

import android.widget.ImageView
import com.bumptech.glide.Glide

const val POKEMON_KEY = "pokemon_url"

fun ImageView.loadUrl(url: String) {
    Glide.with(context).load(url).into(this)
}