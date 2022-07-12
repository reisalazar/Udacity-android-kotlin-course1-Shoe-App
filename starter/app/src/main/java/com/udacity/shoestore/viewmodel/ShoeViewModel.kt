package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val shoes = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<List<Shoe>>()
    val navigateToListingScreen = MutableLiveData<Boolean>()
    val shoe: LiveData<List<Shoe>> get() = _shoes

    fun addShoe(shoe: Shoe) {
        shoes.add(shoe)
        _shoes.value = shoes
        navigateToListingScreen.value = true
    }
}