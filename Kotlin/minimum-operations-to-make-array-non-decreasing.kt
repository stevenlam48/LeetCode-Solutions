package minimumoperationstomakearraynondecreasing

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray): Long {
        var result = 0L
        for (i in 0 until nums.size - 1) {
            result += maxOf(nums[i] - nums[i + 1], 0)
        }
        return result
    }
}
