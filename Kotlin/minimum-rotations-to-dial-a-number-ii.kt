package minimumrotationstodialanumberii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minRotations(n: Int, s: String): Int {
        fun f(a: Char, b: Char): Int {
            val diff = kotlin.math.abs(a.code - b.code)
            return minOf(diff, 10 - diff)
        }

        var result = 0
        var mx = 0
        for (i in s.indices) {
            val prev = if (i - 1 >= 0) s[i - 1] else '0'
            result += f(s[i], prev)
            mx = maxOf(mx, f(s[i], prev) - f(s.last(), prev))
        }
        return result - mx
    }
}
