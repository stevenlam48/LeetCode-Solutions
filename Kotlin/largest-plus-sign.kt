package largestplussign

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun orderOfLargestPlusSign(N: Int, mines: Array<IntArray>): Int {
        val lookup = HashSet<Pair<Int, Int>>()
        for (mine in mines) {
            lookup.add(Pair(mine[0], mine[1]))
        }
        val dp = Array(N) { IntArray(N) }
        var result = 0
        for (i in 0 until N) {
            var l = 0
            for (j in 0 until N) {
                l = if (lookup.contains(Pair(i, j))) 0 else l + 1
                dp[i][j] = l
            }
            l = 0
            for (j in N - 1 downTo 0) {
                l = if (lookup.contains(Pair(i, j))) 0 else l + 1
                dp[i][j] = minOf(dp[i][j], l)
            }
        }

        for (j in 0 until N) {
            var l = 0
            for (i in 0 until N) {
                l = if (lookup.contains(Pair(i, j))) 0 else l + 1
                dp[i][j] = minOf(dp[i][j], l)
            }
            l = 0
            for (i in N - 1 downTo 0) {
                l = if (lookup.contains(Pair(i, j))) 0 else l + 1
                dp[i][j] = minOf(dp[i][j], l)
                result = maxOf(result, dp[i][j])
            }
        }
        return result
    }
}
