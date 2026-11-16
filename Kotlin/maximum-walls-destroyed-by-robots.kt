package maximumwallsdestroyedbyrobots

// Time:  O(nlogn + mlogm)
// Space: O(n)

class Solution {
    fun maxWalls(robots: IntArray, distance: IntArray, walls: IntArray): Int {
        val INF = Int.MAX_VALUE

        val xd = ArrayList<IntArray>()
        xd.add(intArrayOf(0, 0))
        for (i in robots.indices) {
            xd.add(intArrayOf(robots[i], distance[i]))
        }
        xd.add(intArrayOf(INF, 0))
        xd.sortBy { it[0] }
        walls.sort()
        var left0 = 0
        var left1 = 0
        var right = 0
        var curr = 0
        var dp = IntArray(2)
        var newDp = IntArray(2)
        for (i in 1 until xd.size - 1) {
            while (curr < walls.size && walls[curr] < xd[i][0]) {
                curr++
            }
            val r = minOf(xd[i][0] + xd[i][1], xd[i + 1][0] - 1)
            while (right < walls.size && walls[right] <= r) {
                right++
            }
            newDp[1] = maxOf(dp[0], dp[1]) + (right - curr)
            if (curr < walls.size && walls[curr] == xd[i][0]) {
                curr++
            }
            val l0 = maxOf(xd[i][0] - xd[i][1], xd[i - 1][0] + 1)
            while (left0 < walls.size && walls[left0] < l0) {
                left0++
            }
            val l1 = maxOf(
                minOf(xd[i - 1][0] + xd[i - 1][1], xd[i][0] - 1) + 1,
                maxOf(xd[i][0] - xd[i][1], xd[i - 1][0] + 1)
            )
            while (left1 < walls.size && walls[left1] < l1) {
                left1++
            }
            newDp[0] = maxOf(dp[0] + (curr - left0), dp[1] + (curr - left1))
            val tmp = dp
            dp = newDp
            newDp = tmp
        }
        return maxOf(dp[0], dp[1])
    }
}
