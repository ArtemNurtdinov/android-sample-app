package com.nefrit.common.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.nefrit.common.databinding.ToolBarBinding
import com.nefrit.common.utils.gone
import com.nefrit.common.utils.show

class Toolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ToolBarBinding = ToolBarBinding.inflate(LayoutInflater.from(context), this, true)

    fun setTitle(title: String) {
        binding.titleTv.text = title
    }

    fun showHomeButton() {
        binding.backImg.show()
    }

    fun hideHomeButton() {
        binding.backImg.gone()
    }

    fun setHomeButtonListener(listener: (View) -> Unit) {
        binding.backImg.setOnClickListener(listener)
    }
}