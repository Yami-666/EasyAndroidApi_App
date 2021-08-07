package com.example.timekillapp.features.example

import androidx.fragment.app.viewModels
import com.example.timekillapp.core.base.BaseFragment

class ExampleFragment : BaseFragment<ExampleViewModel>() {
    
    override val viewModel: ExampleViewModel by viewModels()
}