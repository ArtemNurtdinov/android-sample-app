package com.nefrit.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.nefrit.ui.R
import com.nefrit.ui.util.makeGone
import com.nefrit.ui.util.makeVisible
import kotlinx.android.synthetic.main.tool_bar.view.backImg
import kotlinx.android.synthetic.main.tool_bar.view.titleTv

class Toolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.tool_bar, this)
    }

    fun setTitle(title: String) {
        titleTv.text = title
    }

    fun showHomeButton() {
        backImg.makeVisible()
    }

    fun hideHomeButton() {
        backImg.makeGone()
    }

    fun setHomeButtonListener(listener: (View) -> Unit) {
        backImg.setOnClickListener(listener)
    }
}