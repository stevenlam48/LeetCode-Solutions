package minimumtotaldistancetraveled

// Time:  O(mlogm + nlogn + m * n)
// Space: O(n)

// sort, dp, prefix sum, mono deque
class Solution {
    fun minimumTotalDistance(robot: IntArray, factory: Array<IntArray>): Long {
        val INF = Long.MAX_VALUE
        robot.sort()
        factory.sortWith(compareBy({ it[0] }, { it[1] }))
        val dp = LongArray(robot.size + 1) { INF }
        dp[0] = 0
        for (i in factory.indices) {
            var prefix = 0L
            val dq = java.util.ArrayDeque<Pair<Long, Int>>()
            dq.addLast(Pair(dp[0] - prefix, 0))
            for (j in 1..robot.size) {
                prefix += Math.abs(robot[j - 1] - factory[i][0]).toLong()
                if (j - dq.peekFirst().second == factory[i][1] + 1) {
                    dq.pollFirst()
                }
                val cand = if (dp[j] != INF) dp[j] - prefix else INF
                while (dq.isNotEmpty() && dq.peekLast().first >= cand) {
                    dq.pollLast()
                }
                dq.addLast(Pair(cand, j))
                dp[j] = if (dq.peekFirst().first != INF) dq.peekFirst().first + prefix else INF
            }
        }
        return dp.last()
    }
}
