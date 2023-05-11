package com.example.pokemonapp.ui.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.pokemonapp.databinding.ItemPokemonBinding
import com.example.pokemonapp.model.Result

class PokemonAdapter(
    private val context: Context,
    var onItemClicked: (url: String) -> Unit,
) : PagingDataAdapter<Result, PokemonViewHolder>(PokemonComparator) {

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let{
            holder.bind(it)
            onItemClicked(it.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(ItemPokemonBinding.inflate(LayoutInflater.from(context)))
    }
}