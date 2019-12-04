package com.nefrit.user.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.base.BaseViewModel
import com.nefrit.model.User
import com.nefrit.user.domain.UserInteractor
import io.reactivex.android.schedulers.AndroidSchedulers

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Int
) : BaseViewModel() {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    init {
        disposables.add(
            interactor.getUser(userId)
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _userLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }
}