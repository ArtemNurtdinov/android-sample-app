package com.nefrit.users.presentation.list

import android.content.Context
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _usersLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}