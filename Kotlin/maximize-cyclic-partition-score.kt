package maximizecyclicpartitionscore

// Time:  O(n * k)
// Space: O(k)

// dp
class Solution {
    fun maximumScore(nums: IntArray, k: Int): Long {
        fun bestTimeToBuyAndSellStockV(base: Int): Long {
            val NEG_INF = Long.MIN_VALUE
            val n = nums.size
            var dp = LongArray(n + 1)
            var result = 0L
            for (i in 0 until k) {
                val newDp = LongArray(n + 1) { NEG_INF }
                var x = NEG_INF
                var y = NEG_INF
                for (j in i until n) {
                    val v = nums[(base + j) % n].toLong()
                    x = maxOf(x, dp[j] - v)
                    y = maxOf(y, dp[j] + v)
                    newDp[j + 1] = maxOf(newDp[j], x + v, y - v)
                }
                dp = newDp
                result = maxOf(result, dp[n])
            }
            return result
        }

        var minIdx = 0
        for (i in nums.indices) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i
            }
        }
        return maxOf(bestTimeToBuyAndSellStockV(minIdx), bestTimeToBuyAndSellStockV(minIdx + 1))
    }
}
