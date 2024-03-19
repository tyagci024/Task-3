package com.example.taskthree.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.taskthree.databinding.FragmentHiddenNumberBinding
import com.example.taskthree.viewmodel.GuessViewModel

class HiddenNumberFragment : Fragment() {
    private val viewModel: GuessViewModel by activityViewModels()
    private lateinit var binding: FragmentHiddenNumberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHiddenNumberBinding.inflate(inflater, container, false)
        binding.textViewHiddenNumber.text = StringBuilder(GUESS_NUMBER_MESSAGE+viewModel.randomIntObs.value.toString())

        return binding.root
    }
    companion object{
        private const val GUESS_NUMBER_MESSAGE = "Tahmin edilmesi gerekilen sayı "
    }
}