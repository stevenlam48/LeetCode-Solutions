package splitarraywithminimumdifference
// Time:  O(n)
// Space: O(1)

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun splitArray(nums: IntArray): Long {
        var left = 0L
        var i = 0
        while (i + 1 < nums.size && nums[i] < nums[i + 1]) {
            left += nums[i]
            i++
        }
        var right = 0L
        var j = nums.size - 1
        while (j - 1 >= 0 && nums[j] < nums[j - 1]) {
            right += nums[j]
            j--
        }
        if (j - i + 1 >= 3) {
            return -1
        }
        if (j - i + 1 == 2) {
            return abs((right + nums[j]) - (left + nums[i]))
        }
        return min(abs(right - (left + nums[i])), abs((right + nums[j]) - left))
    }
}
