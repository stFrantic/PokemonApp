package com.example.pokemonapp.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemonapp.POKEMON_KEY
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentInfoBinding
import com.example.pokemonapp.loadUrl
import com.example.pokemonapp.ui.list.PokemonListFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val viewModel by viewModels<InfoViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = arguments?.getString(POKEMON_KEY)
        if (!url.isNullOrBlank()) {
            val id = url.filter { it.isDigit() }.drop(1)
            viewModel.getInfo(id)
            viewModel.data.observe(viewLifecycleOwner){
                binding.apply {
                    name.text = it.name
                    type.text = it.types.toString()
                    weight.text = it.weight.toString()
                    height.text = it.height.toString()
                    image.loadUrl(it.sprites.front_default)
                    backButton.setOnClickListener(){
                        parentFragmentManager.beginTransaction().replace(
                            R.id.container,
                            PokemonListFragment()
                        ).commit()
                    }
                }
            }
        }

    }
}