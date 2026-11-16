package findallduplicatesinanarray

import kotlin.math.abs

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findDuplicates(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        for (i in nums) {
            if (nums[abs(i) - 1] < 0) {
                result.add(abs(i))
            } else {
                nums[abs(i) - 1] *= -1
            }
        }
        return result
    }
}
