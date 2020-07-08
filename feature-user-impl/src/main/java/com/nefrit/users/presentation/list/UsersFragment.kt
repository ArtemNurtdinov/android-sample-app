package com.nefrit.users.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nefrit.common.base.BaseFragment
import com.nefrit.common.di.FeatureUtils
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.users.R
import com.nefrit.users.di.UserFeatureComponent
import kotlinx.android.synthetic.main.fragment_users.toolbar
import kotlinx.android.synthetic.main.fragment_users.usersRv

class UsersFragment : BaseFragment<UsersViewModel>() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun inject() {
        FeatureUtils.getFeature<UserFeatureComponent>(this, UserFeatureApi::class.java)
            .usersComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun initViews() {
        toolbar.setTitle(getString(R.string.users_title))

        usersRv.layoutManager = LinearLayoutManager(activity!!)
        usersRv.setHasFixedSize(true)
    }

    override fun subscribe(viewModel: UsersViewModel) {
        viewModel.usersLiveData.observe(this, Observer {
            if (usersRv.adapter == null) {
                usersRv.adapter = UsersAdapter { viewModel.userClicked(it) }
            }
            (usersRv.adapter as UsersAdapter).submitList(it)
        })

        viewModel.getUsers()
    }
}