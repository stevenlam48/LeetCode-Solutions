package painthouseii
// Time:  O(n * k)
// Space: O(k)

class Solution {
    fun minCostII(costs: Array<IntArray>): Int {
        if (costs.isEmpty()) {
            return 0
        }
        val minCost = Array(2) { costs[0].copyOf() }
        val n = costs.size
        val k = costs[0].size
        for (i in 1 until n) {
            var smallest = Int.MAX_VALUE
            var secondSmallest = Int.MAX_VALUE
            for (j in 0 until k) {
                if (minCost[(i - 1) % 2][j] < smallest) {
                    secondSmallest = smallest
                    smallest = minCost[(i - 1) % 2][j]
                } else if (minCost[(i - 1) % 2][j] < secondSmallest) {
                    secondSmallest = minCost[(i - 1) % 2][j]
                }
            }
            for (j in 0 until k) {
                val minJ = if (minCost[(i - 1) % 2][j] != smallest) smallest else secondSmallest
                minCost[i % 2][j] = costs[i][j] + minJ
            }
        }
        return minCost[(n - 1) % 2].min()
    }
}
