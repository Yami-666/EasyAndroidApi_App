package com.example.timekillapp.features.example

import androidx.fragment.app.viewModels
import com.example.timekillapp.R
import com.example.timekillapp.core.base.BaseBindingFragment
import com.example.timekillapp.databinding.FragmentExampleBinding

class ExampleFragment : BaseBindingFragment<FragmentExampleBinding, ExampleViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_example

    override val viewModel: ExampleViewModel by viewModels()

    override fun initBinding(binding: FragmentExampleBinding) {
        super.initBinding(binding)
        binding.textView.text = "Fuck you!"
    }
}