package p3sumclosest

import kotlin.math.abs

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var result = 0
        var minDiff = Int.MAX_VALUE
        for (i in nums.size - 1 downTo 2) {
            if (i + 1 < nums.size && nums[i] == nums[i + 1]) {
                continue
            }
            var left = 0
            var right = i - 1
            while (left < right) {
                val total = nums[left] + nums[right] + nums[i]
                if (total < target) {
                    ++left
                } else if (total > target) {
                    --right
                } else {
                    return target
                }
                if (abs(total - target) < minDiff) {
                    minDiff = abs(total - target)
                    result = total
                }
            }
        }
        return result
    }
}
