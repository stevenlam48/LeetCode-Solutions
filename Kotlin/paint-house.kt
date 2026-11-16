package painthouse
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCost(costs: Array<IntArray>): Int {
        if (costs.isEmpty()) {
            return 0
        }
        val minCost = Array(2) { costs[0].copyOf() }
        val n = costs.size
        for (i in 1 until n) {
            minCost[i % 2][0] = costs[i][0] + minOf(minCost[(i - 1) % 2][1], minCost[(i - 1) % 2][2])
            minCost[i % 2][1] = costs[i][1] + minOf(minCost[(i - 1) % 2][0], minCost[(i - 1) % 2][2])
            minCost[i % 2][2] = costs[i][2] + minOf(minCost[(i - 1) % 2][0], minCost[(i - 1) % 2][1])
        }
        val last = minCost[(n - 1) % 2]
        return minOf(last[0], minOf(last[1], last[2]))
    }
}
