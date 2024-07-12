package com.nefrit.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.nefrit.common.R
import com.nefrit.common.navigation.NavigationOwner
import com.nefrit.common.utils.Event
import com.nefrit.common.utils.EventCollector
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    @Inject protected open lateinit var viewModel: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        initViews()
        subscribe(viewModel)

        if (showNavigationBar()) {
            (activity as NavigationOwner).showBottomNav()
        } else {
            (activity as NavigationOwner).hideBottomNav()
        }

        lifecycleScope.launch {
            launch {
                viewModel.alert.collectEvent(::showAlert)
            }
            launch {
                viewModel.errorWithTitle.collectEvent(::showErrorWithTitle)
            }
        }
    }

    protected fun showAlert(alertMessage: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(R.string.common_error_general_title)
            .setMessage(alertMessage)
            .setPositiveButton(R.string.common_ok) { _, _ -> }
            .show()
    }

    protected fun showErrorWithTitle(payload: BaseViewModel.BaseDialogData) {
        AlertDialog.Builder(requireContext())
            .setTitle(payload.title)
            .setMessage(payload.message)
            .setPositiveButton(android.R.string.ok) { _, _ -> }
            .show()
    }

    protected suspend fun <T> Flow<Event<T>>.collectEvent(collector: EventCollector<T>) {
        collect(collector)
    }

    protected suspend fun <T> Flow<Event<T>>.collectEvent(collector: (T) -> Unit) {
        collect(EventCollector { collector(it) })
    }

    abstract fun initViews()

    abstract fun inject()

    abstract fun subscribe(viewModel: T)

    abstract fun showNavigationBar(): Boolean
}