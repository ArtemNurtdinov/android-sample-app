package com.nefrit.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nefrit.common.utils.Event
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    data class BaseDialogData(
        val title: String,
        val message: String,
    )

    private val _alert = MutableSharedFlow<Event<String>>()
    val alert: SharedFlow<Event<String>> = _alert

    private val _errorWithTitle = MutableSharedFlow<Event<BaseDialogData>>()
    val errorWithTitle: SharedFlow<Event<BaseDialogData>> = _errorWithTitle

    protected fun showAlert(errorText: String) {
        viewModelScope.launch {
            _alert.emit(Event(errorText))
        }
    }

    protected fun showErrorDialog(dialogData: BaseDialogData) {
        viewModelScope.launch {
            _errorWithTitle.emit(Event(dialogData))
        }
    }
}