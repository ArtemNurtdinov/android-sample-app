package com.nefrit.user.presentation

import android.content.Context
import android.content.Intent
import android.view.MenuItem
import androidx.lifecycle.Observer
import com.nefrit.common.base.BaseActivity
import com.nefrit.common.utils.findComponentDependencies
import com.nefrit.user.R
import com.nefrit.user.di.UserComponent
import kotlinx.android.synthetic.main.activity_user.firstNameTv
import kotlinx.android.synthetic.main.activity_user.lastNameTv
import kotlinx.android.synthetic.main.activity_user.toolbar

class UserActivity : BaseActivity<UserViewModel>() {

    companion object {

        private const val KEY_USER_ID = "user_id"

        fun start(context: Context, userId: Int) {
            val intent = Intent(context, UserActivity::class.java).apply {
                putExtra(KEY_USER_ID, userId)
            }
            context.startActivity(intent)
        }
    }

    override fun inject() {
        val userId = intent.getIntExtra(KEY_USER_ID, 0)

        UserComponent
            .init(this, userId, findComponentDependencies())
            .inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_user
    }

    override fun initViews() {
        toolbar.setTitle(getString(R.string.user_title))
        toolbar.setHomeButtonListener { finish() }
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
            finish()
        }
        return super.onOptionsItemSelected(menuItem)
    }
}