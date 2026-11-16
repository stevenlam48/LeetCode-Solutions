package minimumoperationstoequalizearray

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun minOperations(nums: IntArray): Int {
        return if (nums.all { it == nums[0] }) 0 else 1
    }
}
