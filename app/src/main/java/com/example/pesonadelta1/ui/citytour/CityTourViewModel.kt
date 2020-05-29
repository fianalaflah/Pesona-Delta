package com.example.pesonadelta1.ui.citytour

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CityTourViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is CityTour Fragment"
    }
    val text: LiveData<String> = _text
}