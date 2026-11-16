package dicerollsimulation

// Time:  O(m * n), m is the max of rollMax
// Space: O(m)

class Solution {
    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val mod = 1_000_000_007
        var dp = Array(6) { i -> IntArray(rollMax[i]).also { it[0] = 1 } }
        var remaining = n
        while (--remaining > 0) {
            val newDp = Array(6) { IntArray(rollMax[it]) }
            for (i in 0 until 6) {
                for (k in 0 until rollMax[i]) {
                    for (j in 0 until 6) {
                        if (i == j) {
                            if (k < rollMax[i] - 1) {
                                newDp[j][k + 1] = (newDp[j][k + 1] + dp[i][k]) % mod
                            }
                        } else {
                            newDp[j][0] = (newDp[j][0] + dp[i][k]) % mod
                        }
                    }
                }
            }
            dp = newDp
        }
        var result = 0L
        for (row in dp) {
            var total = 0L
            for (value in row) {
                total = (total + value) % mod
            }
            result = (result + total) % mod
        }
        return result.toInt()
    }
}
