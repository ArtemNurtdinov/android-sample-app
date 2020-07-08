package com.nefrit.app

import android.content.Context
import android.content.Intent
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.nefrit.app.di.deps.findComponentDependencies
import com.nefrit.app.di.main.MainComponent
import com.nefrit.app.navigation.Navigator
import com.nefrit.common.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject lateinit var navigator: Navigator

    private var navController: NavController? = null

    override fun inject() {
        MainComponent
            .init(this, findComponentDependencies())
            .inject(this)
    }

    override fun layoutResource(): Int {
        return R.layout.activity_main
    }

    override fun initViews() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navigator.attachNavController(navController!!, R.navigation.main_nav_graph)
    }

    override fun subscribe(viewModel: MainViewModel) {
    }

    override fun onDestroy() {
        super.onDestroy()
        navController?.let {
            navigator.detachNavController(it)
        }
    }
}