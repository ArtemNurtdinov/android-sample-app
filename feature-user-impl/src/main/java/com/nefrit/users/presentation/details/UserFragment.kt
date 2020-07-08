package com.nefrit.users.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.nefrit.common.base.BaseFragment
import com.nefrit.common.di.FeatureUtils
import com.nefrit.feature_user_api.di.UserFeatureApi
import com.nefrit.users.R
import com.nefrit.users.di.UserFeatureComponent
import kotlinx.android.synthetic.main.fragment_user.firstNameTv
import kotlinx.android.synthetic.main.fragment_user.lastNameTv
import kotlinx.android.synthetic.main.fragment_user.toolbar

class UserFragment : BaseFragment<UserViewModel>() {

    companion object {
        private const val KEY_USER_ID = "user_id"

        fun createBundle(userId: Int): Bundle {
            return Bundle().apply { putInt(KEY_USER_ID, userId) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun inject() {
        val userId = arguments!!.getInt(KEY_USER_ID, 0)

        FeatureUtils.getFeature<UserFeatureComponent>(this, UserFeatureApi::class.java)
            .userComponentFactory()
            .create(this, userId)
            .inject(this)
    }

    override fun initViews() {
        toolbar.setTitle(getString(R.string.user_title))
     //   toolbar.setHomeButtonListener { finish() }
        toolbar.showHomeButton()
    }

    override fun subscribe(viewModel: UserViewModel) {
        viewModel.userLiveData.observe(this, Observer {
            firstNameTv.text = it.firstName
            lastNameTv.text = it.lastName
        })
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
     //       finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}