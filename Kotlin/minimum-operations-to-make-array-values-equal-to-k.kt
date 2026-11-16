package minimumoperationstomakearrayvaluesequaltok

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        val mn = nums.minOrNull()!!
        return if (mn >= k) nums.toSet().size - if (mn == k) 1 else 0 else -1
    }
}
