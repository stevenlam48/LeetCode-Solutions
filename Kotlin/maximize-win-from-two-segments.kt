package maximizewinfromtwosegments

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximizeWin(prizePositions: IntArray, k: Int): Int {
        val dp = IntArray(prizePositions.size + 1)
        var result = 0
        var left = 0
        for (right in prizePositions.indices) {
            while (prizePositions[right] - prizePositions[left] > k) {
                ++left
            }
            dp[right + 1] = maxOf(dp[right], right - left + 1)
            result = maxOf(result, dp[left] + (right - left + 1))
        }
        return result
    }
}
