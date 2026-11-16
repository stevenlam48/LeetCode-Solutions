package findtheminimumcostarraypermutation

// Time:  O((n-1)^2 * 2^(n-1))
// Space: O((n-1) * 2^(n-1))

// dp, backtracing
class Solution {
    fun findPermutation(nums: IntArray): IntArray {
        val INF = Int.MAX_VALUE

        val n = nums.size
        val size = 1 shl (n - 1)
        val dp = Array(size) { Array(n - 1) { intArrayOf(INF, -1) } }
        for (i in 0 until n - 1) {
            dp[1 shl i][i] = intArrayOf(kotlin.math.abs((i + 1) - nums[0]), -1)
        }
        for (mask in 0 until size) {
            for (i in 0 until n - 1) {
                if ((mask and (1 shl i)) == 0) {
                    continue
                }
                for (j in 0 until n - 1) {
                    if (j == i || (mask and (1 shl j)) == 0) {
                        continue
                    }
                    val base = dp[mask xor (1 shl i)][j][0]
                    if (base == INF) {
                        continue
                    }
                    val cand = base + kotlin.math.abs((i + 1) - nums[j + 1])
                    if (cand < dp[mask][i][0]) {
                        dp[mask][i][0] = cand
                        dp[mask][i][1] = j
                    }
                }
            }
        }
        var minIdx = -1
        for (i in 0 until n - 1) {
            if (minIdx == -1 ||
                dp[size - 1][i][0] + kotlin.math.abs(0 - nums[i + 1]) <
                dp[size - 1][minIdx][0] + kotlin.math.abs(0 - nums[minIdx + 1])
            ) {
                minIdx = i
            }
        }
        val result = ArrayList<Int>()
        result.add(0)
        var i = minIdx
        var mask = size - 1
        while (i != -1) {
            result.add(i + 1)
            val next = dp[mask][i][1]
            mask = mask xor (1 shl i)
            i = next
        }
        return result.toIntArray()
    }
}
