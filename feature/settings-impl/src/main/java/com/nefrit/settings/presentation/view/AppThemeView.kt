package com.nefrit.settings.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.nefrit.settings.R
import com.nefrit.settings.databinding.ViewAppThemeBinding

class AppThemeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    enum class Mode {
        LIGHT,
        DARK,
        FOLLOW_SYSTEM,
        AUTO_BATTERY
    }

    private val binding: ViewAppThemeBinding = ViewAppThemeBinding.inflate(LayoutInflater.from(context), this)

    fun setMode(mode: Mode) {
        when (mode) {
            Mode.LIGHT -> updateView(R.drawable.outline_light_mode_24, context.getString(R.string.settings_app_theme_light))
            Mode.DARK -> updateView(R.drawable.outline_mode_night_24, context.getString(R.string.settings_app_theme_light))
            else -> updateView(R.drawable.baseline_phonelink_setup_24, context.getString(R.string.settings_app_theme_system))
        }
    }

    private fun updateView(iconRes: Int, text: String) {
        binding.themeImg.setImageResource(iconRes)
        binding.themeValueTv.text = text
    }
}