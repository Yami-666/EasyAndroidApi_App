package com.example.timekillapp.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingFragment<VB : ViewDataBinding, VM : BaseViewModel> : BaseFragment<VM>() {

    private var _binding: VB? = null
    private val binding: VB
        get() = _binding ?: throw NullPointerException()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate<VB>(inflater, layoutId,  container, false).also {
            it.lifecycleOwner = viewLifecycleOwner
        }
        initBinding(binding)
        return binding.root
    }

    open fun initBinding(binding: VB) = Unit

    override fun onDestroy() {
        _binding?.unbind()
        _binding = null
        super.onDestroy()
    }
}