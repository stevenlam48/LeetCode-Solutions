package countalternatingsubarrays

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countAlternatingSubarrays(nums: IntArray): Long {
        var result = 0L
        var curr = 0
        for (i in nums.indices) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                curr = 0
            }
            result += ++curr
        }
        return result
    }
}
