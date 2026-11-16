package hexspeak
// Time:  O(n)
// Space: O(1)

class Solution {
    fun toHexspeak(num: String): String {
        val lookup = hashMapOf(0 to 'O', 1 to 'I')
        for (i in 0 until 6) {
            lookup[10 + i] = 'A' + i
        }
        var n = num.toULong()
        val result = StringBuilder()
        while (n != 0uL) {
            val r = (n % 16uL).toInt()
            n /= 16uL
            val digit = lookup[r] ?: return "ERROR"
            result.append(digit)
        }
        return result.reverse().toString()
    }
}
