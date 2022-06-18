package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater,
            R.layout.fragment_instructions, container, false
        )

        binding.btNavToShoelist.setOnClickListener(
            Navigation.
        createNavigateOnClickListener(R.id.action_instructionsFragment_to_shoeList))

        return binding.root
    }
}