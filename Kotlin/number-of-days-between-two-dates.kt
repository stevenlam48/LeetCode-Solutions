package numberofdaysbetweentwodates

// Time:  O(1)
// Space: O(1)

import kotlin.math.abs

class Solution {
    private val lookup = IntArray(12)

    init {
        for (m in 1 until lookup.size) {
            lookup[m] = lookup[m - 1] + dayOfMonth(m)
        }
    }

    fun daysBetweenDates(date1: String, date2: String): Int {
        return abs(dayOfYear(date1) - dayOfYear(date2))
    }

    private fun dayOfYear(date: String): Int {
        val result = date.split('-')
        val year = result[0].toInt()
        val month = result[1].toInt()
        val day = result[2].toInt()
        val leap = if (month > 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) 1 else 0
        return (year - 1) * 365 + ((year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400) +
            lookup[month - 1] + day + leap
    }

    private fun dayOfMonth(month: Int): Int {
        return if (month == 2) 28 else 31 - (month - 1) % 7 % 2
    }
}
