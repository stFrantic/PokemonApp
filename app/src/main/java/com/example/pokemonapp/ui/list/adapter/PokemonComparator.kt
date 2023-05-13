package com.example.pokemonapp.ui.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemonapp.model.Result

object PokemonComparator : DiffUtil.ItemCallback<Result>() {

    override fun areItemsTheSame(oldItem: Result, newItem: Result) =
        oldItem.url == newItem.url

    override fun areContentsTheSame(oldItem: Result, newItem: Result) =
        oldItem.name == newItem.name
}