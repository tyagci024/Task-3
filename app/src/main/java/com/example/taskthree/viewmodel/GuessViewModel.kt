package com.example.taskthree.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskthree.state.GuessResult

class GuessViewModel : ViewModel() {
    private var secretLetter= MutableLiveData<Char>()
    private var secretNumber = 0
    private var randomInt = MutableLiveData<Int>()

    val randomIntObs: LiveData<Int>
        get() = randomInt

    val randomCharObs: LiveData<Char>
        get() = secretLetter

    private val resultMessage = MutableLiveData<GuessResult>()
    val resultMessageObs: LiveData<GuessResult>
        get() = resultMessage

    init {
        startNewGame()
    }

    fun startNewGame() {
        secretNumber = (0..9).random()
        secretLetter.value = ('a'..'z').random()
        randomInt.value = secretNumber
    }

    fun checkGuess(guess: String) {
        if (guess.toInt() == secretNumber) {
            resultMessage.value = GuessResult.WIN
        } else {
            resultMessage.value = GuessResult.TRY_AGAIN
        }
    }
}
