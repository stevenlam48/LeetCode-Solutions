package minimumcosttosplitintoonesii

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minCost(n: Int): Long {
        return n * (n - 1L) / 2
    }
}
