package com.example.pokemonapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokemonapp.POKEMON_KEY
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonListBinding
import com.example.pokemonapp.ui.info.InfoFragment
import com.example.pokemonapp.ui.list.adapter.PokemonAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    private lateinit var binding: FragmentPokemonListBinding
    private val viewModel by viewModels<PokemonListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pokemonListRecyclerView.run {
            if (adapter == null) {
                adapter = PokemonAdapter(requireContext()) { info ->
                    parentFragmentManager.beginTransaction().setCustomAnimations(
                        R.animator.open_info,
                        R.animator.close_info,
                        R.animator.open_info_2,
                        R.animator.close_info_2
                    )
                        .replace(R.id.container, InfoFragment().apply {
                            arguments = Bundle().apply {
                                putSerializable(POKEMON_KEY, info)
                            }
                        }).commit()
                }
            }
            layoutManager = GridLayoutManager(requireContext(), 1)
            isNestedScrollingEnabled = true
            lifecycleScope.launch {
                viewModel.result.collectLatest {
                    setData(it)
                }
            }
        }
    }

    private fun setData(list: PagingData<com.example.pokemonapp.model.Result>) {
        (binding.pokemonListRecyclerView.adapter as PokemonAdapter).submitData(lifecycle, list)
    }

}