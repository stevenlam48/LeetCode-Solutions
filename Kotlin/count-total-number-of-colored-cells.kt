package counttotalnumberofcoloredcells

// Time:  O(1)
// Space: O(1)

class Solution {
    fun coloredCells(n: Int): Long {
        return 1L * n * n + 1L * (n - 1) * (n - 1)
    }
}
