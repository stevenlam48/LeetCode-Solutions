package closestdessertcost

import kotlin.math.abs
import kotlin.math.max

// Time:  O(m * max(max_base, target + max_topping / 2)) ~= O(m * t)
// Space: O(max(max_base, target + max_topping / 2)) ~= O(t)
class Solution {
    fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
        val maxBase = baseCosts.maxOrNull()!!
        val maxTopping = toppingCosts.maxOrNull()!!
        val dp = BooleanArray(max(maxBase, target + maxTopping / 2) + 1)
        for (base in baseCosts) {
            dp[base] = true
        }
        for (topping in toppingCosts) {
            for (count in 0 until 2) {
                for (i in dp.size - 1 - topping downTo 1) {
                    if (dp[i]) {
                        dp[i + topping] = true
                    }
                }
            }
        }
        var result = Int.MAX_VALUE
        for (i in 1 until dp.size) {
            if (!dp[i]) {
                continue
            }
            if (abs(i - target) < abs(result - target)) {
                result = i
            }
            if (i >= target) {
                break
            }
        }
        return result
    }
}
