package numberofperfectpairs

// Time:  O(nlogn)
// Space: O(1)

// sort, two pointers, math
class Solution {
    fun perfectPairs(nums: IntArray): Long {
        for (i in nums.indices) {
            nums[i] = kotlin.math.abs(nums[i])
        }
        nums.sort()
        var result: Long = 0
        var left = 0
        for (right in nums.indices) {
            while (!(nums[right] - nums[left] <= nums[left])) {
                ++left
            }
            result += (right - left + 1) - 1
        }
        return result
    }
}
