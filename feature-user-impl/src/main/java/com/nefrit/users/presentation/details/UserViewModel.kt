package com.nefrit.users.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.base.BaseViewModel
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.UsersRouter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Int,
    private val router: UsersRouter
) : BaseViewModel() {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    init {
        disposables.add(
            interactor.getUser(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _userLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    fun backClicked() {
        router.returnToUsers()
    }
}