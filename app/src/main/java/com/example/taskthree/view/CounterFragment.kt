package com.example.taskthree.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCounterBinding.inflate(inflater, container, false)
        binding.textviewFragmentCounter.text = counter.toString()
        binding.buttonIncrease.setOnClickListener {

            if (binding.switchButton.isChecked) {
                increaseCounter()
            } else {
                viewModel.incrementCounter()
            }
        }

        viewModel.counterOberser.observe(viewLifecycleOwner, Observer { it ->
            binding.textviewViewmodelCounter.text = it.toString()
        })
        binding.buttonToGuessFragment.setOnClickListener {
            navigateToGuess()
        }

        return binding.root
    }

    private fun increaseCounter() {
        counter++
        binding.textviewFragmentCounter.text = counter.toString()
    }

    fun navigateToGuess(){
        findNavController().navigate(CounterFragmentDirections.toFragmentGuess())
    }
}
