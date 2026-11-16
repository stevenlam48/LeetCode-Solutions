package maximumicecreambars

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxIceCream(costs: IntArray, coins: Int): Int {
        costs.sort()
        var remaining = coins
        for (i in costs.indices) {
            remaining -= costs[i]
            if (remaining < 0) {
                return i
            }
        }
        return costs.size
    }
}
