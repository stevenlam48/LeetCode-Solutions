package integertoenglishwords
// Time:  O(logn) = O(1), n is the value of the integer, which is less than 2^31 - 1
// Space: O(1)

class Solution {
    fun numberToWords(num: Int): String {
        if (num == 0) {
            return "Zero"
        }
        val lookup = mapOf(
            0 to "Zero", 1 to "One", 2 to "Two", 3 to "Three", 4 to "Four",
            5 to "Five", 6 to "Six", 7 to "Seven", 8 to "Eight", 9 to "Nine",
            10 to "Ten", 11 to "Eleven", 12 to "Twelve", 13 to "Thirteen",
            14 to "Fourteen", 15 to "Fifteen", 16 to "Sixteen", 17 to "Seventeen",
            18 to "Eighteen", 19 to "Nineteen", 20 to "Twenty", 30 to "Thirty",
            40 to "Forty", 50 to "Fifty", 60 to "Sixty", 70 to "Seventy",
            80 to "Eighty", 90 to "Ninety"
        )
        val units = arrayOf("", "Thousand", "Million", "Billion")
        val result = mutableListOf<String>()
        var value = num
        var i = 0
        while (value != 0) {
            val current = value % 1000
            if (current != 0) {
                result.add(threeDigits(current, lookup, units[i]))
            }
            value /= 1000
            ++i
        }
        result.reverse()
        return result.joinToString(" ")
    }

    private fun threeDigits(num: Int, lookup: Map<Int, String>, unit: String): String {
        val result = mutableListOf<String>()
        if (num / 100 != 0) {
            result.add(lookup.getValue(num / 100) + " Hundred")
        }
        if (num % 100 != 0) {
            result.add(twoDigits(num % 100, lookup))
        }
        if (unit.isNotEmpty()) {
            result.add(unit)
        }
        return result.joinToString(" ")
    }

    private fun twoDigits(num: Int, lookup: Map<Int, String>): String {
        if (lookup.containsKey(num)) {
            return lookup.getValue(num)
        }
        return lookup.getValue(num / 10 * 10) + " " + lookup.getValue(num % 10)
    }
}
