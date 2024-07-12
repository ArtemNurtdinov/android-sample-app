package com.nefrit.users.presentation.list

import androidx.lifecycle.viewModelScope
import com.nefrit.common.resources.ResourceManager
import com.nefrit.common.utils.Event
import com.nefrit.ui.base.BaseViewModel
import com.nefrit.users.domain.UserInteractor
import com.nefrit.users.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersViewModel(
    private val interactor: UserInteractor,
    private val resourceManager: ResourceManager,
) : BaseViewModel() {

    private val _users = MutableSharedFlow<List<UsersAdapter.ListItem>>()
    val users: SharedFlow<List<UsersAdapter.ListItem>> = _users

    private val _openUserEvent = MutableSharedFlow<Event<Long>>()
    val openUserEvent: SharedFlow<Event<Long>> = _openUserEvent

    init {
        observeUsers()
    }

    private fun observeUsers() {
        viewModelScope.launch {
            interactor.observeUsers()
                .map(::mapUsers)
                .catch { e -> observeUsersError(e) }
                .collect(::observeUsersSuccess)
        }
    }

    private fun mapUsers(users: List<User>): List<UsersAdapter.ListItem> {
        val sortedByName = users.sortedBy { it.firstName }
        return addHeaders(sortedByName)
    }

    private fun addHeaders(users: List<User>): List<UsersAdapter.ListItem> {
        val resultList = mutableListOf<UsersAdapter.ListItem>()

        val firstUser = users.firstOrNull() ?: return resultList
        var headerLetter = firstUser.firstName.firstOrNull()?.toString() ?: ""

        val firstHeader = UsersAdapter.ListItem.HeaderListItem(headerLetter)
        resultList.add(firstHeader)

        users.forEach {
            val userListItem = mapUser(it)
            val letter = it.firstName.firstOrNull()?.toString() ?: ""
            if (headerLetter != letter) {
                headerLetter = letter
                val header = UsersAdapter.ListItem.HeaderListItem(letter)
                resultList.add(header)
            }
            resultList.add(userListItem)
        }

        return resultList
    }

    private fun mapUser(user: User): UsersAdapter.ListItem {
        return with(user) {
            UsersAdapter.ListItem.UserListItem(id, firstName, lastName)
        }
    }

    private fun observeUsersSuccess(users: List<UsersAdapter.ListItem>) {
        viewModelScope.launch {
            _users.emit(users)
        }
    }

    private fun observeUsersError(error: Throwable) {
    }

    fun userClicked(userListItem: UsersAdapter.ListItem.UserListItem) {
        viewModelScope.launch {
            _openUserEvent.emit(Event(userListItem.id))
        }
    }

    fun updateUsers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                interactor.updateUsers()
            }
        }
    }
}