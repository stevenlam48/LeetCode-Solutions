package maximumweightintwobags

import java.math.BigInteger

// Time:  O(n * w1 * w2)
// Space: O(w1 * w2)

class Solution {
    fun maxWeight(weights: IntArray, w1: Int, w2: Int): Int {
        var dp = Array(w1 + 1) { BigInteger.ZERO }
        dp[0] = BigInteger.ONE
        for (w in weights) {
            val newDp = Array(w1 + 1) { BigInteger.ZERO }
            for (i in 0..w1) {
                var v = dp[i]
                if (i - w >= 0) {
                    v = v.or(dp[i - w])
                }
                v = v.or(dp[i].shiftLeft(w))
                newDp[i] = v
            }
            dp = newDp
        }
        var result = 0
        for (i in 0..w1) {
            for (j in w2 downTo 0) {
                if (dp[i].testBit(j)) {
                    result = maxOf(result, i + j)
                    break
                }
            }
        }
        return result
    }
}
