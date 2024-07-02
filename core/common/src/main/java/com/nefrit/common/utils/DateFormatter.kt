package com.nefrit.common.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DateFormatter {

    private val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    private val simpleDateTimeFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
    private val ddMMMyyyyDateFormatter = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    private val simpleTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    fun formatDate(date: Date): String {
        return simpleDateFormat.format(date)
    }

    fun formatDateTime(date: Date): String {
        return simpleDateTimeFormat.format(date)
    }

    fun formatTime(date: Date): String {
        return simpleTimeFormat.format(date)
    }
}