package com.nefrit.users.presentation.list

import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nefrit.common.base.BaseActivity
import com.nefrit.core_di.FeatureUtils
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.users.R
import com.nefrit.users.di.UserFeatureComponent
import kotlinx.android.synthetic.main.activity_users.toolbar
import kotlinx.android.synthetic.main.activity_users.usersRv

class UsersActivity : BaseActivity<UsersViewModel>() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, UsersActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun inject() {
        FeatureUtils.getFeature<UserFeatureComponent>(this, UserFeatureApi::class.java)
            .usersComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_users
    }

    override fun initViews() {
        toolbar.setTitle(getString(R.string.users_title))

        usersRv.layoutManager = LinearLayoutManager(this)
        usersRv.setHasFixedSize(true)
    }

    override fun subscribe(viewModel: UsersViewModel) {
        viewModel.usersLiveData.observe(this, Observer {
            if (usersRv.adapter == null) {
                usersRv.adapter = UsersAdapter { viewModel.userClicked(this, it) }
            }
            (usersRv.adapter as UsersAdapter).submitList(it)
        })

        viewModel.getUsers()
    }
}