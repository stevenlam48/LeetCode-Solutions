package twocityscheduling

// Time:  O(n) ~ O(n^2), O(n) on average.
// Space: O(1)

class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val sorted = costs.sortedBy { it[0] - it[1] }
        val half = sorted.size / 2
        var result = 0
        for (i in sorted.indices) {
            result += if (i < half) sorted[i][0] else sorted[i][1]
        }
        return result
    }
}
