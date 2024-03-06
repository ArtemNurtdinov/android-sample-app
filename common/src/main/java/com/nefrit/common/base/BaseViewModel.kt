package com.nefrit.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nefrit.common.base.model.DialogData
import com.nefrit.common.utils.Event
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {

    private val _errorLiveData = MutableLiveData<Event<String>>()
    val errorLiveData: LiveData<Event<String>> = _errorLiveData

    private val _errorWithTitleLiveData = MutableLiveData<Event<DialogData>>()
    val errorWithTitleLiveData: LiveData<Event<DialogData>> = _errorWithTitleLiveData

    protected val disposables = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        if (!disposables.isDisposed) disposables.dispose()
    }

    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        add(disposable)
    }

    protected fun showError(errorText: String) {
        _errorLiveData.value = Event(errorText)
    }

    protected fun showErrorDialog(dialogData: DialogData) {
        _errorWithTitleLiveData.value = Event(dialogData)
    }
}