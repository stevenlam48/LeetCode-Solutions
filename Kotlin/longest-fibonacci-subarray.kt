package longestfibonaccisubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var result = 2
        var cnt = 2
        for (i in 2 until nums.size) {
            if (nums[i] != nums[i - 1] + nums[i - 2]) {
                cnt = 2
                continue
            }
            result = maxOf(result, ++cnt)
        }
        return result
    }
}
