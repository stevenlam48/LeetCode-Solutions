package integerbreak
// Time:  O(logn), pow is O(logn).
// Space: O(1)

class Solution {
    fun integerBreak(n: Int): Int {
        if (n < 4) {
            return n - 1
        }
        return when (n % 3) {
            0 -> Math.pow(3.0, (n / 3).toDouble()).toInt()
            2 -> Math.pow(3.0, (n / 3).toDouble()).toInt() * 2
            else -> Math.pow(3.0, (n / 3 - 1).toDouble()).toInt() * 4
        }
    }
}
