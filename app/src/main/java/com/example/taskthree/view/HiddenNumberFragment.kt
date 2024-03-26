package com.example.taskthree.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.taskthree.R
import com.example.taskthree.databinding.FragmentHiddenNumberBinding
import com.example.taskthree.viewmodel.GuessViewModel

class HiddenNumberFragment : Fragment() {
    private val viewModel: GuessViewModel by activityViewModels()
    private lateinit var binding: FragmentHiddenNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHiddenNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewHiddenNumber.text = getString(R.string.gues_number_message, viewModel.randomIntObs.value)
    }
}
