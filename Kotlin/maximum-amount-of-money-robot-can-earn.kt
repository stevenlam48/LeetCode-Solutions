package maximumamountofmoneyrobotcanearn

// Time:  O(m * n * k) = O(m * n)
// Space: O(min(m, n) * k) = O(min(m, n))

class Solution {
    fun maximumAmount(coins: Array<IntArray>): Int {
        val kMax = 2
        val mn = minOf(coins.size, coins[0].size)
        val mx = maxOf(coins.size, coins[0].size)
        val get: (Int, Int) -> Int = if (coins.size == mx) {
            { i, j -> coins[i][j] }
        } else {
            { i, j -> coins[j][i] }
        }
        var dp = Array(mn) { IntArray(kMax + 1) { Int.MIN_VALUE } }
        for (i in 0 until mx) {
            val newDp = Array(mn) { IntArray(kMax + 1) { Int.MIN_VALUE } }
            for (j in 0 until mn) {
                for (k in 0..kMax) {
                    if (i == 0 && j == 0) {
                        newDp[j][k] = if (k - 1 >= 0) maxOf(get(i, j), 0) else get(i, j)
                        continue
                    }
                    if (i - 1 >= 0) {
                        newDp[j][k] = maxOf(newDp[j][k], dp[j][k] + get(i, j))
                        if (k - 1 >= 0) {
                            newDp[j][k] = maxOf(newDp[j][k], dp[j][k - 1])
                        }
                    }
                    if (j - 1 >= 0) {
                        newDp[j][k] = maxOf(newDp[j][k], newDp[j - 1][k] + get(i, j))
                        if (k - 1 >= 0) {
                            newDp[j][k] = maxOf(newDp[j][k], newDp[j - 1][k - 1])
                        }
                    }
                }
            }
            dp = newDp
        }
        return dp[mn - 1][kMax]
    }
}
