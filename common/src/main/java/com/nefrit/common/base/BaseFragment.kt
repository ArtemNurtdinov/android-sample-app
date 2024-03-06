package com.nefrit.common.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.nefrit.common.R
import com.nefrit.common.utils.Event
import com.nefrit.common.utils.EventObserver
import javax.inject.Inject

abstract class BaseFragment<T : BaseViewModel> : Fragment() {

    @Inject protected open lateinit var viewModel: T

    private val observables = mutableListOf<LiveData<*>>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        initViews()
        subscribe(viewModel)

        viewModel.alertLiveData.observeEvent(::showAlert)
        viewModel.errorWithTitleLiveData.observeEvent(::showErrorWithTitle)
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

    override fun onDestroyView() {
        observables.forEach { it.removeObservers(this) }
        super.onDestroyView()
    }

    protected fun <T> LiveData<T>.observe(observer: Observer<T>) {
        observe(viewLifecycleOwner, observer)
        observables.add(this)
    }

    protected fun <T> LiveData<Event<T>>.observeEvent(observer: EventObserver<T>) {
        observe(viewLifecycleOwner, observer)
        observables.add(this)
    }

    protected fun <T> LiveData<Event<T>>.observeEvent(observer: (T) -> Unit) {
        observe(viewLifecycleOwner, EventObserver { observer(it) })
        observables.add(this)
    }

    abstract fun initViews()

    abstract fun inject()

    abstract fun subscribe(viewModel: T)
}