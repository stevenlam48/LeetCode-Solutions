package minimummovestoequalarrayelementsii

import kotlin.math.abs

// Time:  O(n) on average
// Space: O(1)

class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val median = nums[nums.size / 2]
        var result = 0
        for (i in nums) {
            result += abs(i - median)
        }
        return result
    }
}
