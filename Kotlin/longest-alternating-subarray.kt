package longestalternatingsubarray

// Time:  O(n)
// Space: O(1)

// array
class Solution {
    fun alternatingSubarray(nums: IntArray): Int {
        var result = -1
        var l = -1
        for (i in 0 until nums.size - 1) {
            if (l != -1 && nums[i - 1] == nums[i + 1]) {
                ++l
            } else {
                l = if (nums[i + 1] - nums[i] == 1) 2 else -1
            }
            result = maxOf(result, l)
        }
        return result
    }
}
