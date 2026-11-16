package racecar

// Time : O(nlogn), n is the value of the target
// Space: O(n)

class Solution {
    fun racecar(target: Int): Int {
        val dp = IntArray(target + 1)
        for (i in 1..target) {
            val k = bitLength(i)
            if (i == (1 shl k) - 1) {
                dp[i] = k
                continue
            }
            dp[i] = dp[(1 shl k) - 1 - i] + k + 1
            for (j in 0 until k) {
                dp[i] = minOf(dp[i], dp[i - (1 shl (k - 1)) + (1 shl j)] + k + j + 1)
            }
        }
        return dp[target]
    }

    private fun bitLength(n0: Int): Int {
        val n = n0.toLong() and 0xFFFFFFFFL
        var left = 1
        var right = 32
        while (left <= right) {
            val mid = left + (right - left) / 2
            if ((1L shl mid) > n) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
