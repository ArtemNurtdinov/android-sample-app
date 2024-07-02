package com.nefrit.users.presentation.details.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.nefrit.users.databinding.ViewUserBinding

class UserView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    data class Payload(
        val firstName: String,
        val lastName: String,
    )

    private val binding = ViewUserBinding.inflate(LayoutInflater.from(context), this)

    init {
        orientation = VERTICAL
    }

    fun populate(payload: Payload) {
        binding.firstNameTv.text = payload.firstName
        binding.lastNameTv.text = payload.lastName
    }
}