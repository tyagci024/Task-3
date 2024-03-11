package com.example.taskthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val counter = MutableLiveData<Int>()
    val counterOberser: LiveData<Int>
        get() = counter

    init {
        counter.value = 0
    }

    fun incrementCounter() {
        counter.value = (counter.value ?: 0) + 1
    }
}
