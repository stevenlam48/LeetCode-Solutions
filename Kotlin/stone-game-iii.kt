package stonegameiii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun stoneGameIII(stoneValue: IntArray): String {
        val dp = IntArray(3) { Int.MIN_VALUE }
        dp[stoneValue.size % 3] = 0
        for (i in stoneValue.size - 1 downTo 0) {
            var maxDp = Int.MIN_VALUE
            var curr = 0
            var j = 0
            while (j < 3 && i + j < stoneValue.size) {
                curr += stoneValue[i + j]
                maxDp = maxOf(maxDp, curr - dp[(i + j + 1) % 3])
                ++j
            }
            dp[i % 3] = maxDp
        }
        return if (dp[0] == 0) "Tie" else if (dp[0] > 0) "Alice" else "Bob"
    }
}
