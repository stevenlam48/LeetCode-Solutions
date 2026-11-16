package dayoftheyear

// Time:  O(1)
// Space: O(1)

class Solution {
    private val lookup = IntArray(12)

    init {
        for (m in 1 until lookup.size) {
            lookup[m] = lookup[m - 1] + dayOfMonth(m)
        }
    }

    fun dayOfYear(date: String): Int {
        val result = date.split('-')
        val y = result[0].toInt()
        val m = result[1].toInt()
        val d = result[2].toInt()
        val leap = if (m > 2 && (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0))) 1 else 0
        return lookup[m - 1] + d + leap
    }

    private fun dayOfMonth(m: Int): Int {
        return if (m == 2) 28 else 31 - (m - 1) % 7 % 2
    }
}
