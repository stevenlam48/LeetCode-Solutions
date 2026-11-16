package longestidealsubsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestIdealString(s: String, k: Int): Int {
        val dp = IntArray(26)
        for (c in s) {
            val x = c - 'a'
            dp[x] = dp.sliceArray(maxOf(x - k, 0) until minOf(x + k + 1, 26)).max() + 1
        }
        return dp.max()
    }
}
