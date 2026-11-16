package dayoftheweek

// Time:  O(1)
// Space: O(1)

class Solution {
    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val days = arrayOf(
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday",
        )

        var m = month
        var y0 = year
        // Zeller Formula
        if (m < 3) {
            m += 12
            --y0
        }
        val c = y0 / 100
        val y = y0 % 100
        val w = ((c / 4 - 2 * c + y + y / 4 + 13 * (m + 1) / 5 + day - 1) % 7 + 7) % 7
        return days[w]
    }
}
