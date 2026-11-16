package minimumtotalcosttoprocessallelements

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumCost(nums: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        val sum = nums.sumOf { it.toLong() }
        val count = ((sum + k - 1) / k - 1 + mod) % mod
        return ((1L + count) * count / 2 % mod).toInt()
    }
}
