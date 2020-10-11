package com.app.avatar.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.app.avatar.ServiceLocator
import com.app.avatar.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    private lateinit var binding: DetailFragmentBinding

    private val viewModel by viewModels<DetailViewModel> {
        DetailViewModelFactory(
            ServiceLocator.provideRepository(
                requireContext()
            )
        )
    }

    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        with(args.imdbId) {
            viewModel.refreshMovieInfo(this)
            viewModel.getObserver(this).observe(viewLifecycleOwner, Observer {
                binding.item = it
            })
        }
    }

}