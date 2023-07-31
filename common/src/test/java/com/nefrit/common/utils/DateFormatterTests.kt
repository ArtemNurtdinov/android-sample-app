package com.nefrit.common.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Date

class DateFormatterTests {

    private lateinit var dateFormatter: DateFormatter

    @Before
    fun setUp() {
        dateFormatter = DateFormatter()
    }

    @Test
    fun testDateFormatting() {
        val firstDate = Date(1581627600000) // 14.02.2020 00:00:00
        val secondDate = Date(1546131312000) // 30.12.2018 03:55:12
        val thirdDate = Date(1751815893000) // 06.07.2025 18:31:33

        assertEquals(dateFormatter.formatDate(firstDate), "14.02.2020")
        assertEquals(dateFormatter.formatDateTime(firstDate), "14.02.2020 00:00")
        assertEquals(dateFormatter.formatDate(secondDate), "30.12.2018")
        assertEquals(dateFormatter.formatDateTime(secondDate), "30.12.2018 03:55")
        assertEquals(dateFormatter.formatDate(thirdDate), "06.07.2025")
        assertEquals(dateFormatter.formatDateTime(thirdDate), "06.07.2025 18:31")
    }
}