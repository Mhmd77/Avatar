package com.app.avatar.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.app.avatar.ServiceLocator
import com.app.avatar.databinding.MovieListFragmentBinding

class MovieListFragment : Fragment() {
    private lateinit var binding: MovieListFragmentBinding

    private lateinit var adapter: MovieAdapter

    private val viewModel by viewModels<MovieListViewModel> {
        MovieListViewModelFactory(
            ServiceLocator.provideRepository(
                requireContext()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        setupList()
        setupNavigation()
    }

    private fun setupNavigation() {
        viewModel.navigateToDetailEvent.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let { id ->
                findNavController().navigate(
                    MovieListFragmentDirections.actionMovieListFragmentToDetailFragment(
                        id
                    )
                )
            }
        })
    }

    private fun setupList() {
        adapter = MovieAdapter(viewModel).also {
            binding.movieList.adapter = it
        }
    }

}