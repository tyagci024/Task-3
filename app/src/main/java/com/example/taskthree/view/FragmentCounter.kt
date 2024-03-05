package com.example.taskthree.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.taskthree.R
import com.example.taskthree.databinding.FragmentCounterBinding
import com.example.taskthree.viewmodel.CounterViewModel


class FragmentCounter : Fragment() {
    private var counter : Int=0
    private lateinit var binding : FragmentCounterBinding
    private val viewModel: CounterViewModel by viewModels()
    private lateinit var counterObserver: Observer<Int>




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCounterBinding.inflate(inflater,container,false)
        counterObserver = Observer { counter ->
            binding.viewmodelCounter.text = counter.toString()
        }



        binding.increaseButton.setOnClickListener {
            if (binding.switchButton.isChecked) {
                viewModel.incrementCounter()
            }
            else {
                increaseCounter()
                binding.fragmentCounter.text=counter.toString()

            }
        }


        viewModel.getCounter().observe(viewLifecycleOwner, counterObserver)

        return binding.root
    }

    fun increaseCounter(){
        counter++
    }


}