package com.nefrit.users.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.nefrit.common.base.BaseFragment
import com.nefrit.common.di.FeatureUtils
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.users.R
import com.nefrit.users.databinding.FragmentUsersBinding
import com.nefrit.users.di.UserFeatureComponent

class UsersFragment : BaseFragment<UsersViewModel>() {

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
        with (binding) {
            toolbar.setTitle(getString(R.string.users_title))

            usersRv.layoutManager = LinearLayoutManager(requireActivity())
            usersRv.setHasFixedSize(true)
        }
    }

    override fun subscribe(viewModel: UsersViewModel) {
        viewModel.usersLiveData.observe(this) {
            with(binding) {
                if (usersRv.adapter == null) {
                    usersRv.adapter = UsersAdapter(viewModel::userClicked)
                }
                (usersRv.adapter as UsersAdapter).submitList(it)
            }
        }

        viewModel.getUsers()
    }
}