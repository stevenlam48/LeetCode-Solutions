package absolutedifferencebetweenmaximumandminimumkelements

import kotlin.math.abs

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun absDifference(nums: IntArray, k: Int): Int {
        nums.sort()
        var total1 = 0
        for (i in 0 until k) {
            total1 += nums[i]
        }
        var total2 = 0
        for (i in nums.size - k until nums.size) {
            total2 += nums[i]
        }
        return abs(total1 - total2)
    }
}
