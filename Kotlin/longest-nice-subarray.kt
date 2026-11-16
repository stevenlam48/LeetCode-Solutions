package longestnicesubarray

// Time:  O(n)
// Space: O(1)

// sliding window, two pointers
class Solution {
    fun longestNiceSubarray(nums: IntArray): Int {
        var result = 0
        var left = 0
        var curr = 0
        for (right in nums.indices) {
            while (curr and nums[right] != 0) {
                curr = curr xor nums[left]
                ++left
            }
            curr = curr or nums[right]
            result = maxOf(result, right - left + 1)
        }
        return result
    }
}
