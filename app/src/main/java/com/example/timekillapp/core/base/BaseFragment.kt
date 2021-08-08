package com.example.timekillapp.core.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.example.timekillapp.utils.extensions.handleViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference

abstract class BaseFragment<VM: BaseViewModel> : Fragment(), IBaseFragment<VM> {

    abstract override val viewModel: VM

//    override val contentView: View? = null
//
//    override var weakContentRef: WeakReference<View>? = null
//    override var weakLoadingRef: WeakReference<View>? = null
//    override var weakToolbarRef: WeakReference<Toolbar>? = null

    override fun onMenuItemClick(item: MenuItem?): Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            viewModelScope.launch {
                supportFlow.collect(::handleViewState)
                anyResultFlow.collect(::handleViewState)
            }
        }
    }
}