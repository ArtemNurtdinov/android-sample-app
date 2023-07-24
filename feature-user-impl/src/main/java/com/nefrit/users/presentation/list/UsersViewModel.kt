package com.nefrit.users.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.base.BaseViewModel
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersViewModel(
    private val interactor: UserInteractor,
    private val router: UsersRouter,
) : BaseViewModel() {

    private val _usersLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> = _usersLiveData

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
        router.openUser(user.id)
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