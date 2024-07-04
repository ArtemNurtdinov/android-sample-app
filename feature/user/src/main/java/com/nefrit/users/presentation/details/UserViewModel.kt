package com.nefrit.users.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.utils.Event
import com.nefrit.common.utils.SimpleEvent
import com.nefrit.common.utils.plusAssign
import com.nefrit.ui.base.BaseViewModel
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.model.User
import com.nefrit.users.presentation.details.model.UserDetailsModel
import com.nefrit.users.presentation.details.view.UserView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Long,
    private val resourceManager: ResourceManager,
) : BaseViewModel() {

    private val _userLiveData = MutableLiveData<UserDetailsModel>()
    val userLiveData: LiveData<UserDetailsModel> = _userLiveData

    private val _returnToUsersLiveData = MutableLiveData<Event<SimpleEvent>>()
    val returnToUsersLiveData: LiveData<Event<SimpleEvent>> = _returnToUsersLiveData

    init {
        disposables += interactor.observeUser(userId)
            .subscribeOn(Schedulers.io())
            .map(::mapUserDetails)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::observeUserSuccess, ::observeUserError)
    }

    private fun observeUserSuccess(user: UserDetailsModel) {
        _userLiveData.value = user
    }

    private fun observeUserError(error: Throwable) {
    }

    private fun mapUserDetails(user: User): UserDetailsModel {
        return with(user) {
            val payload = UserView.Payload(firstName, lastName)
            UserDetailsModel(payload)
        }
    }

    fun updateUser() {
        disposables += interactor.updateUser(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::userUpdateSuccess, ::userUpdateError)
    }

    fun backClicked() {
        _returnToUsersLiveData.value = Event(SimpleEvent())
    }

    private fun userUpdateSuccess() {
    }

    private fun userUpdateError(error: Throwable) {
    }
}