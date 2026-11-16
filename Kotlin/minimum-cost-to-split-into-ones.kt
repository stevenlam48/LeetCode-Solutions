package minimumcosttosplitintoones

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minCost(n: Int): Int {
        fun nC2(n: Int): Int {
            return n * (n - 1) / 2
        }

        return nC2(n)
    }
}
