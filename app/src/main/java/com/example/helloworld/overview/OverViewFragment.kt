package com.example.helloworld.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.helloworld.R
import com.example.helloworld.databinding.FragmentOverviewBinding
import com.example.helloworld.databinding.GridViewItemBinding


class OverviewFragment : Fragment() {
    
    private val viewModel: OverviewViewModel by lazy {
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
//        val binding = GridViewItemBinding.inflate(inflater)


        binding.setLifecycleOwner(this)

        binding.viewModel = viewModel

        binding.photosGrid.adapter = PhotoGridAdapter()


        setHasOptionsMenu(true)
        return binding.root
    }
    
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}