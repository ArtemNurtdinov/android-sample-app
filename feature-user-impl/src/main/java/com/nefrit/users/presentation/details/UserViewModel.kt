package com.nefrit.users.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.base.BaseViewModel
import com.nefrit.feature_user_api.domain.interfaces.UserInteractor
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.UsersRouter
import com.nefrit.users.presentation.details.model.UserDetailsModel
import com.nefrit.users.presentation.details.view.UserView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Int,
    private val router: UsersRouter,
) : BaseViewModel() {

    private val _userLiveData = MutableLiveData<UserDetailsModel>()
    val userLiveData: LiveData<UserDetailsModel> = _userLiveData

    init {
        disposables.add(
            interactor.getUser(userId)
                .subscribeOn(Schedulers.io())
                .map(::mapUserDetailsModel)
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe({
                    _userLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    private fun mapUserDetailsModel(user: User): UserDetailsModel {
        return with (user) {
            val payload = UserView.Payload(firstName, lastName)
            UserDetailsModel(payload)
        }
    }

    fun backClicked() {
        router.returnToUsers()
    }
}