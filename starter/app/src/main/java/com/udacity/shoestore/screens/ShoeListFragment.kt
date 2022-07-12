package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_list.*
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var shoeViewModel: ShoeViewModel
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this


        val shoeObserver = Observer<List<Shoe>> { newShoe ->
            if (!newShoe.isNullOrEmpty()) {
                newShoe.forEach { shoe ->
                    val textView = TextView(this.context)

                    val content = "Name: ${shoe.name}\n" +
                            "Company: ${shoe.company}\n" +
                            "Size: ${shoe.size}\n" +
                            "Description: ${shoe.description}\n"
                    textView.text = content
                    textView.textSize = 16F

                    binding.shoeListLayout.addView(textView)
                }
            }
        }

        shoeViewModel.shoe.observe(viewLifecycleOwner, shoeObserver)

        binding.fabNewShoe.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().popBackStack()
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab_new_shoe.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
            shoeViewModel.navigateToListingScreen.value = false
        }
    }
}