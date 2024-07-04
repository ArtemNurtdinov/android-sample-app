package com.nefrit.app

import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.nefrit.app.databinding.ActivityMainBinding
import com.nefrit.app.di.main.MainComponent
import com.nefrit.app.di.main.MainDependenciesProvider
import com.nefrit.app.navigation.Navigator
import com.nefrit.ui.base.BaseActivity
import com.nefrit.common.navigation.NavigationOwner
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>(), NavigationOwner {

    @Inject lateinit var navigator: Navigator

    private var navController: NavController? = null

    private lateinit var binding: ActivityMainBinding

    override fun inject() {
        val dependencies = (applicationContext as MainDependenciesProvider).provideMainDependencies()
        MainComponent.create(this, dependencies).inject(this)
    }

    override fun rootView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initViews() {
        setupNavigation()
    }

    private fun setupNavigation() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navigator.attachNavController(navController!!, R.navigation.main_nav_graph)
        binding.bottomNavigation.setupWithNavController(navController!!)
    }

    override fun showBottomNav() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }

    override fun hideBottomNav() {
        binding.bottomNavigation.visibility = View.GONE
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