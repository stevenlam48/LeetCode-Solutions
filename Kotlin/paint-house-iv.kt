package painthouseiv
// Time:  O(n * l^4)
// Space: O(l^2)

class Solution {
    fun minCost(n: Int, cost: Array<IntArray>): Long {
        val l = cost[0].size
        var dp = Array(l) { LongArray(l) }
        for (k in 0 until n) {
            if (k * 2 >= n) {
                break
            }
            val newDp = Array(l) { LongArray(l) { Long.MAX_VALUE } }
            for (i in 0 until l) {
                for (j in 0 until l) {
                    if (j == i) {
                        continue
                    }
                    for (ni in 0 until l) {
                        if (ni == i) {
                            continue
                        }
                        for (nj in 0 until l) {
                            if (nj == j || ni == nj) {
                                continue
                            }
                            newDp[ni][nj] = minOf(
                                newDp[ni][nj],
                                dp[i][j] + cost[k][ni] + cost[n - 1 - k][nj]
                            )
                        }
                    }
                }
            }
            dp = newDp
        }
        var result = Long.MAX_VALUE
        for (i in 0 until l) {
            for (j in 0 until l) {
                if (i != j) {
                    result = minOf(result, dp[i][j])
                }
            }
        }
        return result
    }
}
