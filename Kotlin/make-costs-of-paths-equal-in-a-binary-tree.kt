package makecostsofpathsequalinabinarytree

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs
import kotlin.math.max

class Solution {
    fun minIncrements(n: Int, cost: IntArray): Int {
        var result = 0
        for (i in n / 2 - 1 downTo 0) {
            result += abs(cost[2 * i + 1] - cost[2 * i + 2])
            cost[i] += max(cost[2 * i + 1], cost[2 * i + 2])
        }
        return result
    }
}
