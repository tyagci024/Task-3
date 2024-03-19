package com.example.taskthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val counter = MutableLiveData<Int>(0)
    val counterObserver: LiveData<Int>
        get() = counter
    fun incrementCounter() {
        counter.value = counter.value?.plus(1)
    }
}
