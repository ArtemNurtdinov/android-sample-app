package com.nefrit.common.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.Date

class DateFormatterTests {

    companion object {
        private val TEST_DATE_1 = DateTestData(Date(1581627600000), "14.02.2020 00:00:00")
        private val TEST_DATE_2 = DateTestData(Date(1546131312000), "30.12.2018 03:55:12")
        private val TEST_DATE_3 = DateTestData(Date(1751815893000), "06.07.2025 18:31:33")
    }

    private lateinit var dateFormatter: DateFormatter

    private data class DateTestData(
        val date: Date,
        val fullDateStr: String
    )

    @Before
    fun setUp() {
        dateFormatter = DateFormatter()
    }

    @Test
    fun testDateFormatting() {
        assertEquals(dateFormatter.formatDate(TEST_DATE_1.date), "14.02.2020")
        assertEquals(dateFormatter.formatDateTime(TEST_DATE_1.date), "14.02.2020 00:00")
        assertEquals(dateFormatter.formatDate(TEST_DATE_2.date), "30.12.2018")
        assertEquals(dateFormatter.formatDateTime(TEST_DATE_2.date), "30.12.2018 03:55")
        assertEquals(dateFormatter.formatDate(TEST_DATE_3.date), "06.07.2025")
        assertEquals(dateFormatter.formatDateTime(TEST_DATE_3.date), "06.07.2025 18:31")
    }
}