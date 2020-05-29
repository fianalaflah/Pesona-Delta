package com.example.pesonadelta1.ui.wisata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WisataViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Wisata Fragment"
    }
    val text: LiveData<String> = _text
}