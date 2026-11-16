package largestelementinanarrayaftermergeoperations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxArrayValue(nums: IntArray): Long {
        var result = 0L
        var curr = 0L
        for (i in nums.indices.reversed()) {
            if (nums[i] > curr) {
                curr = 0
            }
            curr += nums[i]
            result = maxOf(result, curr)
        }
        return result
    }
}
