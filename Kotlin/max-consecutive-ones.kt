package maxconsecutiveones

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var localMax = 0
        for (n in nums) {
            localMax = if (n != 0) localMax + 1 else 0
            result = maxOf(result, localMax)
        }
        return result
    }
}
