package com.nefrit.users.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.nefrit.ui.base.BaseFragment
import com.nefrit.common.utils.SimpleEvent
import com.nefrit.users.R
import com.nefrit.users.databinding.FragmentUserBinding
import com.nefrit.users.di.UserFeatureDependenciesProvider
import com.nefrit.users.presentation.UsersRouter
import com.nefrit.users.presentation.details.di.UserComponent
import com.nefrit.users.presentation.details.model.UserDetailsModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserFragment : BaseFragment<UserViewModel>() {

    companion object {
        private const val KEY_USER_ID = "user_id"

        fun createBundle(userId: Long): Bundle {
            return Bundle().apply { putLong(KEY_USER_ID, userId) }
        }
    }

    @Inject lateinit var router: UsersRouter

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun inject() {
        val userId = requireArguments().getLong(KEY_USER_ID, 0)
        val dependencies = (context?.applicationContext as UserFeatureDependenciesProvider).provideUserFeatureDependencies()
        UserComponent.create(this, userId, dependencies).inject(this)
    }

    override fun initViews() {
        with(binding.toolbar) {
            setTitle(getString(R.string.user_title))
            setHomeButtonListener { viewModel.backClicked() }
            showHomeButton()
        }
    }

    override fun subscribe(viewModel: UserViewModel) {
        lifecycleScope.launch {
            launch {
                viewModel.user.collect(::updateUserDetails)
            }
            launch {
                viewModel.returnToUsers.collectEvent(::navigateBackToUsers)
            }
        }

        viewModel.updateUser()
    }

    override fun showNavigationBar(): Boolean {
        return false
    }

    private fun updateUserDetails(userDetails: UserDetailsModel) {
        binding.userView.populate(userDetails.userPayload)
    }

    private fun navigateBackToUsers(event: SimpleEvent) {
        router.returnToUsers()
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            viewModel.backClicked()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}