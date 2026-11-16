package countnozeropairsthatsumton

// Time:  O(10 * 2^4 * logn)
// Space: O(2^3)

// dp
class Solution {
    fun countNoZeroPairs(n: Long): Long {
        var dp = Array(2) { Array(2) { LongArray(2) } }
        dp[0][0][0] = 1
        var start = 1
        var m = n
        while (m != 0L) {
            val d = m % 10
            val newDp = Array(2) { Array(2) { LongArray(2) } }
            for (c in 0 until 2) {
                for (i in 0 until 2) {
                    for (j in 0 until 2) {
                        if (dp[c][i][j] == 0L) {
                            continue
                        }
                        for (x in start..(if (i == 0) 9 else 0)) {
                            for (nc in 0 until 2) {
                                val y = (d + nc * 10) - (c + x)
                                if (!(start.toLong() <= y && y <= (if (j == 0) 9L else 0L))) {
                                    continue
                                }
                                newDp[nc][if (i != 0 || x == 0) 1 else 0][if (j != 0 || y == 0L) 1 else 0] += dp[c][i][j]
                            }
                        }
                    }
                }
            }
            start = 0
            dp = newDp
            m /= 10
        }
        var result = 0L
        for (i in 0 until 2) {
            for (j in 0 until 2) {
                result += dp[0][i][j]
            }
        }
        return result
    }
}
