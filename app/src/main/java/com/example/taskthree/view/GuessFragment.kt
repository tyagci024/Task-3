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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCharBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonConnectEditText()
        viewModel.resultMessageObs.observe(viewLifecycleOwner) { message ->
            if (message == TRY_AGAIN_MESSAGE) {
                binding.textViewGuessHint.text = viewModel.randomCharObs.toString()
            } else if (message == WIN_MESSAGE) {
                binding.textViewGuessHint.text =
                    StringBuilder().append(GUESS_CHARACTER_HINT + viewModel.randomIntObs.value.toString())
            }
        }
    }

    private fun buttonConnectEditText() {
        binding.apply {
            textViewGuessHint.setOnClickListener {
                findNavController().navigate(GuessFragmentDirections.toHiddenNumberFragment())
            }
            buttonClear.setOnClickListener {
                editTextGuess.text.clear()
            }

            buttonGuess.setOnClickListener {
                val guessText = binding.editTextGuess.text.toString().trim()
                if (guessText.isNotEmpty()) {
                    viewModel.checkGuess(guessText)
                } else {
                    Toast.makeText(requireContext(), ENTER_CHARACTER_MESSAGE, Toast.LENGTH_SHORT)
                        .show()
                }
            }
            val buttonList = arrayOf(
                button0,
                button1,
                button2,
                button3,
                button4,
                button5,
                button6,
                button7,
                button8,
                button9)
            buttonList.forEach { button ->
                button.setOnClickListener {
                    binding.editTextGuess.text.clear()
                    binding.editTextGuess.append(button.text)
                }
            }
        }
    }
    companion object {
        private const val TRY_AGAIN_MESSAGE = "Tekrar dene!"
        private const val WIN_MESSAGE = "Kazandın!"
        private const val GUESS_CHARACTER_HINT = "Doğru Cevap : "
        private const val ENTER_CHARACTER_MESSAGE = "Karakter girin!!"
    }
}
