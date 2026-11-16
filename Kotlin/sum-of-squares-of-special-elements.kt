package sumofsquaresofspecialelements

// Time:  O(sqrt(n))
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun sumOfSquares(nums: IntArray): Int {
        var result = 0
        val sqrtN = sqrt(nums.size.toDouble()).toInt()
        for (i in 1..sqrtN) {
            if (nums.size % i != 0) {
                continue
            }
            result += nums[i - 1] * nums[i - 1]
            if (nums.size / i != i) {
                result += nums[nums.size / i - 1] * nums[nums.size / i - 1]
            }
        }
        return result
    }
}
