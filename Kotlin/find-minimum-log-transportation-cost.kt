package findminimumlogtransportationcost

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minCuttingCost(n: Int, m: Int, k: Int): Long {
        return k.toLong() * maxOf(n - k, m - k, 0)
    }
}
