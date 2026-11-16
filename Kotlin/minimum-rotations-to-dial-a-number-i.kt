package minimumrotationstodialanumberi

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minRotations(s: String): Int {
        fun f(a: Char, b: Char): Int {
            val diff = kotlin.math.abs(a.code - b.code)
            return minOf(diff, 10 - diff)
        }

        var result = 0
        for (i in s.indices) {
            result += f(s[i], if (i - 1 >= 0) s[i - 1] else '0')
        }
        return result
    }
}
