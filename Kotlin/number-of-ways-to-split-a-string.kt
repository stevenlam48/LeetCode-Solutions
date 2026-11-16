package numberofwaystosplitastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numWays(s: String): Int {
        val mod = 1_000_000_007L
        var ones = s.count { it == '1' }
        if (ones % 3 != 0) {
            return 0
        }
        ones /= 3
        if (ones == 0) {
            return ((s.length - 1).toLong() * (s.length - 2) / 2 % mod).toInt()
        }
        var count = 0
        var left = 0
        var right = 0
        for (c in s) {
            if (c == '1') {
                ++count
            }
            if (count == ones) {
                ++left
            } else if (count == 2 * ones) {
                ++right
            }
        }
        return (left.toLong() * right % mod).toInt()
    }
}
