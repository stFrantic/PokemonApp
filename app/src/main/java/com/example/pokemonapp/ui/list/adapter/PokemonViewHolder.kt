package com.example.pokemonapp.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.Result

class PokemonViewHolder(
    private val binding: ItemPokemonBinding,

    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Result) {
        binding.name.run {
            text = item.name
            isClickable = true
        }
    }

}