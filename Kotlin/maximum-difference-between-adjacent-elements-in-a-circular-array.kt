package maximumdifferencebetweenadjacentelementsinacirculararray

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun maxAdjacentDistance(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            result = maxOf(result, abs(nums[i] - if (i - 1 >= 0) nums[i - 1] else nums.last()))
        }
        return result
    }
}
