package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding  = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
        R.layout.fragment_login, container, false)

        binding.btLogin.setOnClickListener(Navigation.
        createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragmentclass3))

        binding.btNewAccLogin.setOnClickListener(Navigation.
        createNavigateOnClickListener(R.id.action_loginFragment_to_welcomeFragmentclass3))

        return binding.root
    }
}
