package com.example.taskthree.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.taskthree.databinding.FragmentCharBinding
import com.example.taskthree.viewmodel.GuessViewModel

class GuessFragment : Fragment() {
    private lateinit var binding: FragmentCharBinding
    private val viewModel: GuessViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCharBinding.inflate(inflater, container, false)
        buttonConnectEditText()

        viewModel.resultMessageObs.observe(
            viewLifecycleOwner) {
            if (it == "Tekrar dene!") {
                binding.textViewGuessHint.text = viewModel.randomCharObs.toString()
            } else if (it == "Kazandın!"){
                binding.textViewGuessHint.text=
                    StringBuilder().append(
                    "$it Doğru Cevap : ${viewModel.randomIntObs.value.toString()}")
            }
        }

        return binding.root
    }

    fun buttonConnectEditText() {
        binding.apply {
            textViewGuessHint.setOnClickListener {
                findNavController().navigate(GuessFragmentDirections.toHiddenNumberFragment())
            }

            buttonGuess.setOnClickListener {
                val guessText = binding.editTextGuess.text.toString().trim()
                if (guessText.isNotEmpty()) {
                    viewModel.checkGuess(guessText)
                } else {
                    Toast.makeText(requireContext(), "Karakter girin!!", Toast.LENGTH_SHORT).show()
                }
            }
            button0.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button0.text)
            }
            button1.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button1.text)
            }

            button2.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button2.text)
            }

            button3.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button3.text)
            }
            button4.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button4.text)
            }
            button5.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button5.text)
            }
            button6.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button6.text)
            }
            button7.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button7.text)
            }
            button8.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button8.text)
            }
            button9.setOnClickListener {
                editTextGuess.text.clear()
                editTextGuess.append(button9.text)
            }
            buttonClear.setOnClickListener {
                editTextGuess.text.clear()
            }
        }
    }
}
