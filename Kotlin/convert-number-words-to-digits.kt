package convertnumberwordstodigits

// Time:  O(n)
// Space: O(1)

class Solution {
    fun convertNumber(s: String): String {
        val lookup = mapOf(
            "zero" to '0', "one" to '1', "two" to '2', "three" to '3', "four" to '4',
            "five" to '5', "six" to '6', "seven" to '7', "eight" to '8', "nine" to '9'
        )

        val result = StringBuilder()
        var i = 0
        while (i < s.length) {
            var l = 3
            while (l <= 5) {
                val t = s.substring(i, minOf(i + l, s.length))
                if (lookup.containsKey(t)) {
                    result.append(lookup.getValue(t))
                    break
                }
                ++l
            }
            i += if (l <= 5) l else 1
        }
        return result.toString()
    }
}
