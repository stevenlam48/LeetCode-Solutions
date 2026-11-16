package androidunlockpatterns

import kotlin.math.abs

// Time:  O(9^2 * 2^9)
// Space: O(9 * 2^9)

// DP solution.
class Solution {
    fun numberOfPatterns(m: Int, n: Int): Int {
        val dp = Array(1 shl 9) { IntArray(9) }
        for (i in 0 until 9) {
            dp[merge(0, i)][i] = 1
        }

        var res = 0
        for (used in dp.indices) {
            val number = numberOfKeys(used)
            if (number > n) {
                continue
            }
            for (i in 0 until 9) {
                if (!contain(used, i)) {
                    continue
                }
                if (m <= number && number <= n) {
                    res += dp[used][i]
                }

                val x1 = i / 3
                val y1 = i % 3
                for (j in 0 until 9) {
                    if (contain(used, j)) {
                        continue
                    }
                    val x2 = j / 3
                    val y2 = j % 3
                    if (((x1 == x2 && abs(y1 - y2) == 2) ||
                            (y1 == y2 && abs(x1 - x2) == 2) ||
                            (abs(x1 - x2) == 2 && abs(y1 - y2) == 2)) &&
                        !contain(used, convert((x1 + x2) / 2, (y1 + y2) / 2))
                    ) {
                        continue
                    }
                    dp[merge(used, j)][j] += dp[used][i]
                }
            }
        }

        return res
    }

    private fun merge(i: Int, j: Int): Int = i or (1 shl j)

    private fun numberOfKeys(i0: Int): Int {
        var i = i0
        var number = 0
        while (i != 0) {
            ++number
            i = i and (i - 1)
        }
        return number
    }

    private fun contain(i: Int, j: Int): Boolean = (i and (1 shl j)) != 0

    private fun convert(i: Int, j: Int): Int = 3 * i + j
}
