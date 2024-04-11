package com.nefrit.users.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nefrit.common.base.BaseFragment
import com.nefrit.common.di.FeatureUtils
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.feature_user_api.domain.model.User
import com.nefrit.users.R
import com.nefrit.users.UsersRouter
import com.nefrit.users.databinding.FragmentUsersBinding
import com.nefrit.users.di.UserFeatureComponent
import javax.inject.Inject

class UsersFragment : BaseFragment<UsersViewModel>(), UsersAdapter.ClickHandler {

    @Inject lateinit var router: UsersRouter

    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun inject() {
        FeatureUtils.getFeature<UserFeatureComponent>(this, UserFeatureApi::class.java)
            .usersComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun initViews() {
        with(binding) {
            toolbar.setTitle(getString(R.string.users_title))
        }
    }

    override fun subscribe(viewModel: UsersViewModel) {
        viewModel.usersLiveData.observe(::updateUsers)
        viewModel.openUserEvent.observeEvent(::navigateToUser)
        viewModel.updateUsers()
    }

    private fun updateUsers(users: List<UsersAdapter.ListItem>) {
        with(binding) {
            if (usersRv.adapter == null) {
                usersRv.adapter = UsersAdapter(this@UsersFragment)
            }
            (usersRv.adapter as UsersAdapter).submitList(users)
        }
    }

    private fun navigateToUser(userId: Long) {
        router.openUser(userId)
    }

    override fun userClicked(userListItem: UsersAdapter.ListItem.UserListItem) {
        viewModel.userClicked(userListItem)
    }
}