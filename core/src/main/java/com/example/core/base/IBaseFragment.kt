package com.example.core.base

import androidx.appcompat.widget.Toolbar

interface IBaseFragment<out VM : BaseViewModel> : Toolbar.OnMenuItemClickListener {
    val viewModel: VM?
    val layoutId: Int

//    val toolbarTitle: String?
//        get() = null
//    val toolbarSubTitle: String?
//        get() = null
//    val toolbarTitleResId: Int?
//        get() = null
//    val toolbarMenuId: Int?
//        get() = null
//    val toolbarBackButtonResId: Int?
//        get() = R.drawable.ic_arrow_back_white_24dp
//    val toolbarNavigationIconColor: Int?
//        get() = null
//
//    /**
//     * Need to center toolbar title
//     */
//    val centerToolbarTitle: Boolean
//        get() = false
//
//    /**
//     * Need to center toolbar subtitle
//     */
//    val centerToolbarSubTitle: Boolean
//        get() = false
//
//    /**
//     * Does this fragment need toolbar back button
//     */
//    val needBackButton: Boolean
//        get() = false
//
//    /**
//     * Can this fragment navigate back or can be pressed back button
//     */
//    val canPressBack: Boolean
//        get() = true
//
//    val contentLayoutResId: Int get() = R.id.contentLayout
//    val loadingLayoutResId: Int get() = R.id.loadingLayout
//    val toolbarLayoutResId: Int get() = R.id.toolbarLayout
//
//    val contentView: View?
//
//    var weakContentRef: WeakReference<View>?
//    var weakLoadingRef: WeakReference<View>?
//    var weakToolbarRef: WeakReference<Toolbar>?
//
//    /**
//     * Main navigation host graph id for current element
//     */
//    val mainHostFragmentId: Int
//        get() = R.id.mainHostFragment
//
//    /**
//     * Toolbar instance
//     */
//    val toolbarView: Toolbar?
//        get() {
//            return weakToolbarRef?.get() ?: contentView?.findViewById<Toolbar>(toolbarLayoutResId)
//                ?.also {
//                    weakToolbarRef = WeakReference(it)
//                }
//        }
//
//    /**
//     * Content Layout
//     */
//    val contentViewLayout: View?
//        get() {
//            return weakContentRef?.get() ?: contentView?.findViewById<View>(contentLayoutResId)
//                ?.also {
//                    weakContentRef = WeakReference(it)
//                }
//        }
//
//    /**
//     * Loading Layout
//     */
//    val loadingViewLayout: View?
//        get() {
//            return weakLoadingRef?.get() ?: contentView?.findViewById<View>(loadingLayoutResId)
//                ?.also {
//                    weakLoadingRef = WeakReference(it)
//                }
//        }
}