package com.example.timekillapp.features.example

import androidx.fragment.app.viewModels
import com.example.core.base.BaseBindingFragment
import com.example.timekillapp.R
import com.example.timekillapp.databinding.FragmentExampleBinding
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class ExampleFragment : BaseBindingFragment<FragmentExampleBinding, ExampleViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_example

    override val viewModel: ExampleViewModel by viewModels()

}