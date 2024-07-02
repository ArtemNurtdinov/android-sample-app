package com.nefrit.settings.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import com.nefrit.common.base.BaseFragment
import com.nefrit.common.di.FeatureUtils
import com.nefrit.settings.R
import com.nefrit.settings.databinding.FragmentSettingsBinding
import com.nefrit.settings.di.SettingsApi
import com.nefrit.settings.di.SettingsComponent
import com.nefrit.settings.presentation.mapper.AppThemeModeMapper
import javax.inject.Inject

class SettingsFragment: BaseFragment<SettingsViewModel>() {

    companion object {

        fun createBundle(): Bundle {
            return Bundle()
        }
    }

    @Inject lateinit var router: SettingsRouter
    @Inject lateinit var appThemeModeMapper: AppThemeModeMapper

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        initAppThemeView()

        with(binding) {
            toolbar.setTitle(getString(R.string.settings_title))
        }
    }

    override fun inject() {
        FeatureUtils.getFeature<SettingsComponent>(this, SettingsApi::class.java)
            .settingsFragmentComponentFactory()
            .create(this)
            .inject(this)
    }

    override fun showNavigationBar(): Boolean {
        return true
    }

    override fun subscribe(viewModel: SettingsViewModel) {
    }

    private fun initAppThemeView() {
        val mode = appThemeModeMapper.mapAppThemeMode(AppCompatDelegate.getDefaultNightMode())
        binding.appThemeView.setMode(mode)
    }
}