package com.nefrit.app

import com.nefrit.app.di.deps.findComponentDependencies
import com.nefrit.app.di.main.MainComponent
import com.nefrit.common.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun inject() {
        MainComponent
            .init(this, findComponentDependencies())
            .inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
    }

    override fun subscribe(viewModel: MainViewModel) {
    }
}