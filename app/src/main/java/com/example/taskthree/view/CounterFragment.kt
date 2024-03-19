package com.example.taskthree.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taskthree.databinding.FragmentCounterBinding
import com.example.taskthree.viewmodel.CounterViewModel

class CounterFragment : Fragment() {
    private var counter: Int = 0
    private lateinit var binding: FragmentCounterBinding
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textviewFragmentCounter.text = counter.toString()
        binding.buttonIncrease.setOnClickListener {
            if (binding.switchButton.isChecked) {
                increaseCounter()
            } else {
                viewModel.incrementCounter()
            }
        }

        viewModel.counterObserver.observe(viewLifecycleOwner) { counter ->
            binding.textviewViewmodelCounter.text = counter.toString()
        }
        binding.buttonToGuessFragment.setOnClickListener {
            navigateToGuess()
        }
    }

    private fun increaseCounter() {
        counter++
        binding.textviewFragmentCounter.text = counter.toString()
    }

    private fun navigateToGuess(){
        findNavController().navigate(CounterFragmentDirections.toFragmentGuess())
    }
}
