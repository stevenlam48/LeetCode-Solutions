package minimumnumberofcoinsforfruitsii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minimumCoins(prices: IntArray): Int {
        val dp = IntArray(prices.size + 1) { Int.MAX_VALUE }
        dp[0] = 0
        val dq = java.util.ArrayDeque<Int>()
        var j = 0
        for (i in prices.indices) {
            while (!dq.isEmpty() && dp[dq.last()] + prices[dq.last()] >= dp[i] + prices[i]) {
                dq.removeLast()
            }
            dq.addLast(i)
            while (j + (j + 1) < i) {
                if (dq.first() == j) {
                    dq.removeFirst()
                }
                ++j
            }
            dp[i + 1] = dp[dq.first()] + prices[dq.first()]
        }
        return dp.last()
    }
}
