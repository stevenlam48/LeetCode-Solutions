package reformatdate
// Time:  O(n)
// Space: O(1)

class Solution {
    fun reformatDate(date: String): String {
        val lookup = mapOf(
            "Jan" to 1, "Feb" to 2, "Mar" to 3, "Apr" to 4,
            "May" to 5, "Jun" to 6, "Jul" to 7, "Aug" to 8,
            "Sep" to 9, "Oct" to 10, "Nov" to 11, "Dec" to 12
        )
        val year = date.substring(date.length - 4).toInt()
        val month = lookup.getValue(date.substring(date.length - 8, date.length - 5))
        val day = date.substring(0, date.indexOf(' ') - 2).toInt()
        return "${year.toString().padStart(4, '0')}-${month.toString().padStart(2, '0')}-${day.toString().padStart(2, '0')}"
    }
}
