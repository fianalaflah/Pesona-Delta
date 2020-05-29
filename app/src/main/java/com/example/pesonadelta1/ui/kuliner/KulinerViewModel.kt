package com.example.pesonadelta1.ui.kuliner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class KulinerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Kuliner Fragment"
    }
    val text: LiveData<String> = _text
}