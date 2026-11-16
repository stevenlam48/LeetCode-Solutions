package maximumheightbystackingcuboids

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun maxHeight(cuboids: Array<IntArray>): Int {
        for (cuboid in cuboids) {
            cuboid.sort()
        }
        val ordered = mutableListOf(intArrayOf(0, 0, 0))
        ordered.addAll(cuboids)
        ordered.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })
        val dp = IntArray(ordered.size)
        for (i in 1 until ordered.size) {
            for (j in 0 until i) {
                if (ordered[j][0] <= ordered[i][0] &&
                    ordered[j][1] <= ordered[i][1] &&
                    ordered[j][2] <= ordered[i][2]
                ) {
                    dp[i] = maxOf(dp[i], dp[j] + ordered[i][2])
                }
            }
        }
        return dp.maxOrNull() ?: 0
    }
}
