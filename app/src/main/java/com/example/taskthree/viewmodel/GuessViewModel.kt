package com.example.taskthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {

    private var secretChar: Char = ' '
    private var secretInt = 0
    private var randomInt=MutableLiveData<Int>()

    val randomIntObs : LiveData<Int>
        get()=randomInt

    val randomCharObs: Char
        get() = secretChar

    private val resultMessage = MutableLiveData<String>()
    val resultMessageObs: LiveData<String>
        get() = resultMessage

    init {
        startNewGame()
    }

    fun startNewGame() {
        secretInt = (0..9).random()
        secretChar = ('a'..'z').random()
        randomInt.value=secretInt
    }

    fun checkGuess(guess: String) {
        if (guess.toInt() == secretInt) {
            resultMessage.value = "Kazandın!"
        } else {
            resultMessage.value = "Tekrar dene!"
        }
    }

}
