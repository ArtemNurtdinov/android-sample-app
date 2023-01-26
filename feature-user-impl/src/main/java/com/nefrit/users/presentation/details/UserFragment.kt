package com.nefrit.users.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.nefrit.common.base.BaseFragment
import com.nefrit.common.di.FeatureUtils
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.users.R
import com.nefrit.users.databinding.FragmentUserBinding
import com.nefrit.users.di.UserFeatureComponent

class UserFragment : BaseFragment<UserViewModel>() {

    companion object {
        private const val KEY_USER_ID = "user_id"

        fun createBundle(userId: Int): Bundle {
            return Bundle().apply { putInt(KEY_USER_ID, userId) }
        }
    }

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun inject() {
        val userId = requireArguments().getInt(KEY_USER_ID, 0)

        FeatureUtils.getFeature<UserFeatureComponent>(this, UserFeatureApi::class.java)
            .userComponentFactory()
            .create(this, userId)
            .inject(this)
    }

    override fun initViews() {
        with(binding) {
            toolbar.setTitle(getString(R.string.user_title))
            toolbar.setHomeButtonListener { viewModel.backClicked() }
            toolbar.showHomeButton()
        }
    }

    override fun subscribe(viewModel: UserViewModel) {
        viewModel.userLiveData.observe {
            binding.userView.populate(it.userPayload)
        }
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            viewModel.backClicked()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}