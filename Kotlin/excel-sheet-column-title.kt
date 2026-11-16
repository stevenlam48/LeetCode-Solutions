package excelsheetcolumntitle

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun convertToTitle(n: Int): String {
        val result = StringBuilder()
        var dvd = n

        while (dvd != 0) {
            result.append(((dvd - 1) % 26 + 'A'.code).toChar())
            dvd = (dvd - 1) / 26
        }
        result.reverse()

        return result.toString()
    }
}
