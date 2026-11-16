package maxconsecutiveonesii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var result = 0
        var prev = 0
        var curr = 0
        for (n in nums) {
            if (n == 0) {
                result = maxOf(result, prev + curr + 1)
                prev = curr
                curr = 0
            } else {
                curr++
            }
        }
        return minOf(maxOf(result, prev + curr + 1), nums.size)
    }
}
