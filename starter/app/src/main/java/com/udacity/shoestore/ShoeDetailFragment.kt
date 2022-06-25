package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(
            inflater,
            R.layout.fragment_shoe_detail, container, false
        )

        binding.btCancel.setOnClickListener() { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }

        binding.btSave.setOnClickListener() { view: View ->




            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeList)
        }


        return binding.root
    }
}