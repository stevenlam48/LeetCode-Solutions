package thenumberofwaystomakethesum

// Time:  O(1)
// Space: O(1)

class Solution {
    fun numberOfWays(n: Int): Int {
        val mod = 1_000_000_007L
        return ((1 + (n / 2 + 1L) * (n / 2) / 2) % mod).toInt()
    }
}
