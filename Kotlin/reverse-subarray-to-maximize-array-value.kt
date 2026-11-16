package reversesubarraytomaximizearrayvalue
// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun maxValueAfterReverse(nums: IntArray): Int {
        var result = 0
        var add = 0
        var maxPair = Int.MIN_VALUE
        var minPair = Int.MAX_VALUE
        for (i in 1 until nums.size) {
            val difference = abs(nums[i - 1] - nums[i])
            result += difference
            add = maxOf(add, abs(nums[0] - nums[i]) - difference, abs(nums[nums.lastIndex] - nums[i - 1]) - difference)
            minPair = minOf(minPair, maxOf(nums[i - 1], nums[i]))
            maxPair = maxOf(maxPair, minOf(nums[i - 1], nums[i]))
        }
        return result + maxOf(add, (maxPair - minPair) * 2)
    }
}
