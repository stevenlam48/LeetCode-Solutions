package countthenumberofwinningsequences
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun countWinningSequences(s: String): Int {
        val lookup = mapOf('F' to 0, 'W' to 1, 'E' to 2)
        var dp = Array(3) { HashMap<Int, Int>() }
        for (i in s.indices) {
            val newDp = Array(3) { HashMap<Int, Int>() }
            val x = lookup.getValue(s[i])
            for (j in 0 until 3) {
                val diff = ((j - x + 1) % 3 + 3) % 3 - 1
                if (i == 0) {
                    newDp[j][diff] = 1
                    continue
                }
                for (k in 0 until 3) {
                    if (k == j) {
                        continue
                    }
                    for ((v, c) in dp[k]) {
                        newDp[j][v + diff] = (newDp[j].getOrDefault(v + diff, 0) + c) % MOD
                    }
                }
            }
            dp = newDp
        }
        var result = 0
        for (j in 0 until 3) {
            for ((v, c) in dp[j]) {
                if (v >= 1) {
                    result = (result + c) % MOD
                }
            }
        }
        return result
    }

    companion object {
        private const val MOD = 1_000_000_007
    }
}
