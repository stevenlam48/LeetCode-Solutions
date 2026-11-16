package maximumcapacitywithinbudget

// Time:  O(n + b)
// Space: O(b)

class Solution {
    fun maxCapacity(costs: IntArray, capacity: IntArray, budget: Int): Int {
        val mid = (budget - 1) / 2
        val lookup = IntArray(budget)
        for (i in costs.indices) {
            if (costs[i] >= budget) {
                continue
            }
            lookup[costs[i]] = maxOf(lookup[costs[i]], capacity[i])
        }
        var i = 0
        while (i + 1 <= mid) {
            lookup[i + 1] = maxOf(lookup[i + 1], lookup[i])
            ++i
        }
        var result = 0
        var mx = 0
        for (j in costs.indices) {
            if (costs[j] > mid) {
                continue
            }
            result = maxOf(result, mx + capacity[j])
            mx = maxOf(mx, capacity[j])
        }
        for (j in mid + 1..budget - 1) {
            result = maxOf(result, lookup[j] + lookup[(budget - 1) - j])
        }
        return result
    }
}
