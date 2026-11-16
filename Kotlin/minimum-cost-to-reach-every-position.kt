package minimumcosttoreacheveryposition

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minCosts(cost: IntArray): IntArray {
        for (i in 1 until cost.size) {
            cost[i] = minOf(cost[i], cost[i - 1])
        }
        return cost
    }
}
