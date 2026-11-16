package numberofbalancedintegersinarange

// Time:  O((logn)^2)
// Space: O(logn)

class Solution {
    fun countBalanced(low: Long, high: Long): Long {
        fun count(n0: Long): Long {
            var n = n0
            val digits = ArrayList<Int>()
            while (n != 0L) {
                digits.add((n % 10).toInt())
                n /= 10
            }
            digits.reverse()
            val shift = digits.size / 2 * 9
            var dp = Array(digits.size * 9 + 1) { LongArray(2) }
            dp[shift][1] = 1
            for (i in digits.indices) {
                val newDp = Array(digits.size * 9 + 1) { LongArray(2) }
                for (curr in dp.indices) {
                    for (tight in 0..1) {
                        if (dp[curr][tight] == 0L) {
                            continue
                        }
                        val bound = if (tight == 1) digits[i] else 9
                        for (d in 0..bound) {
                            val next = if ((i and 1) == 1) curr - d else curr + d
                            newDp[next][if (tight == 1 && d == bound) 1 else 0] += dp[curr][tight]
                        }
                    }
                }
                dp = newDp
            }

            return dp[shift][0]
        }

        return count(high + 1) - count(low)
    }
}
