package com.example.taskthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun getCounter(): LiveData<Int> {
        return counter
    }

    fun incrementCounter() {
        counter.value = (counter.value ?: 0) + 1
    }
}