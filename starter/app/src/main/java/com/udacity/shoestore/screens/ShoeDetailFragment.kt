package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeListViewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeListViewModel = shoeListViewModel
        binding.lifecycleOwner = this

        binding.shoe = Shoe("", "", "", "")

        binding.btCancel.setOnClickListener {
            it.findNavController()
                .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }
        val saveButtonObserver = Observer<Boolean> {
            if (shoeListViewModel.navigateToListingScreen.value == true)
                findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        shoeListViewModel.navigateToListingScreen.observe(viewLifecycleOwner, saveButtonObserver)

        return binding.root
    }
}