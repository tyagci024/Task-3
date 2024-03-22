package com.example.taskthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessViewModel : ViewModel() {
    private var secretLetter: Char = ' '
    private var secretNumber = 0
    private var randomInt = MutableLiveData<Int>()

    val randomIntObs: LiveData<Int>
        get() = randomInt

    val randomCharObs: Char
        get() = secretLetter

    private val resultMessage = MutableLiveData<String>()
    val resultMessageObs: LiveData<String>
        get() = resultMessage

    init {
        startNewGame()
    }

    private fun startNewGame() {
        secretNumber = (0..9).random()
        secretLetter = ('a'..'z').random()
        randomInt.value = secretNumber
    }

    fun checkGuess(guess: String) {
        if (guess.toInt() == secretNumber) {
            resultMessage.value = WIN_MESSAGE
        } else {
            resultMessage.value = TRY_AGAIN_MESSAGE
        }
    }

    companion object {
        private const val TRY_AGAIN_MESSAGE = "Tekrar dene!"
        private const val WIN_MESSAGE = "Kazandın!"
    }
}
