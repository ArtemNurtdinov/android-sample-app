package com.nefrit.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nefrit.common.utils.Event

open class BaseViewModel : ViewModel() {

    data class BaseDialogData(
        val title: String,
        val message: String,
    )

    private val _alertLiveData = MutableLiveData<Event<String>>()
    val alertLiveData: LiveData<Event<String>> = _alertLiveData

    private val _errorWithTitleLiveData = MutableLiveData<Event<BaseDialogData>>()
    val errorWithTitleLiveData: LiveData<Event<BaseDialogData>> = _errorWithTitleLiveData

    protected fun showAlert(errorText: String) {
        _alertLiveData.value = Event(errorText)
    }

    protected fun showErrorDialog(dialogData: BaseDialogData) {
        _errorWithTitleLiveData.value = Event(dialogData)
    }
}