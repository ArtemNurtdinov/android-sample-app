package com.nefrit.users.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.base.BaseViewModel
import com.nefrit.common.core.resources.ResourceManager
import com.nefrit.common.utils.Event
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersViewModel(
    private val interactor: UserInteractor,
    private val resourceManager: ResourceManager
) : BaseViewModel() {

    private val _usersLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> = _usersLiveData

    private val _openUserEvent = MutableLiveData<Event<User>>()
    val openUserEvent: LiveData<Event<User>> = _openUserEvent

    init {
        disposables += interactor.observeUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::observeUsersSuccess, ::observeUsersError)
    }

    private fun observeUsersSuccess(users: List<User>) {
        _usersLiveData.value = users
    }

    private fun observeUsersError(error: Throwable) {
    }

    fun userClicked(user: User) {
        _openUserEvent.value = Event(user)
    }

    fun updateUsers() {
        disposables += interactor.updateUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::updateUsersSuccess, ::updateUsersError)
    }

    private fun updateUsersSuccess() {
    }

    private fun updateUsersError(error: Throwable) {
    }
}