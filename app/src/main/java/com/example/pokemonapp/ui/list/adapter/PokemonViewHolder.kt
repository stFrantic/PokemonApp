package com.example.pokemonapp.ui.list.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.Result
import com.example.pokemonapp.toUpCase

class PokemonViewHolder(
    private val binding: ItemPokemonBinding,
    var onItemClicked: (url: String) -> Unit,

    ) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Result) {
        binding.name.run {
            text = item.name.toUpCase()
            setOnClickListener{
                onItemClicked(item.url)
            }
        }
    }

}