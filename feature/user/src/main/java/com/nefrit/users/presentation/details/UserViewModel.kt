package com.nefrit.users.presentation.details

import androidx.lifecycle.viewModelScope
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.utils.Event
import com.nefrit.common.utils.SimpleEvent
import com.nefrit.ui.base.BaseViewModel
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.model.User
import com.nefrit.users.presentation.details.model.UserDetailsModel
import com.nefrit.users.presentation.details.view.UserView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(
    private val interactor: UserInteractor,
    private val userId: Long,
    private val resourceManager: ResourceManager,
) : BaseViewModel() {

    private val _user = MutableSharedFlow<UserDetailsModel>()
    val user: SharedFlow<UserDetailsModel> = _user

    private val _returnToUsers = MutableSharedFlow<Event<SimpleEvent>>()
    val returnToUsers: SharedFlow<Event<SimpleEvent>> = _returnToUsers

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
        viewModelScope.launch {
            _user.emit(user)
        }
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
        viewModelScope.launch {
            _returnToUsers.emit(Event(SimpleEvent()))
        }
    }
}