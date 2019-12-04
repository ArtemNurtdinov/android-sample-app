package com.nefrit.users.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.base.BaseViewModel
import com.nefrit.model.User
import com.nefrit.users.domain.UsersInteractor
import com.nefrit.users.domain.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers

class UsersViewModel(
    private val interactor: UsersInteractor,
    private val router: UsersRouter
) : BaseViewModel() {

    private val _usersLiveData = MutableLiveData<List<User>>()
    val usersLiveData: LiveData<List<User>> = _usersLiveData

    fun userClicked(context: Context, user: User) {
        router.openUser(context, user.id)
    }

    fun getUsers() {
        disposables.add(
            interactor.getUsers()
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _usersLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}