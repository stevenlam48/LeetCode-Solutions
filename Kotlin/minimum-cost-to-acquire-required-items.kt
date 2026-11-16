package minimumcosttoacquirerequireditems

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long {
        val mn = minOf(need1, need2).toLong()
        val mx = maxOf(need1, need2).toLong()
        return mn * minOf(cost1.toLong() + cost2, costBoth.toLong()) +
            minOf(
                (need1 - mn) * cost1 + (need2 - mn) * cost2,
                (mx - mn) * costBoth
            )
    }
}
