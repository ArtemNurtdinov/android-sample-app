package com.nefrit.users.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.utils.Event
import com.nefrit.common.utils.SimpleEvent
import com.nefrit.common.utils.plusAssign
import com.nefrit.ui.base.BaseViewModel
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.model.User
import com.nefrit.users.presentation.details.model.UserDetailsModel
import com.nefrit.users.presentation.details.view.UserView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Long,
    private val resourceManager: ResourceManager,
) : BaseViewModel() {

    private val _user = MutableLiveData<UserDetailsModel>()
    val user: LiveData<UserDetailsModel> = _user

    private val _returnToUsersLiveData = MutableLiveData<Event<SimpleEvent>>()
    val returnToUsersLiveData: LiveData<Event<SimpleEvent>> = _returnToUsersLiveData

    init {
        observeUser()
    }

    private fun observeUser() {
        viewModelScope.launch {
            interactor.observeUser(userId)
                .map(::mapUserDetails)
                .catch { e -> observeUserError(e) }
                .collect(::observeUserSuccess)
        }
    }

    private fun observeUserSuccess(user: UserDetailsModel) {
        _user.value = user
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
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                interactor.updateUser(userId)
            }
        }
    }

    fun backClicked() {
        _returnToUsersLiveData.value = Event(SimpleEvent())
    }
}