package longestnondecreasingsubarrayafterreplacingatmostoneelement

// Time:  O(n)
// Space: O(n)

// prefix sum
class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) {
            return 0
        }
        val right = IntArray(n) { 1 }
        for (i in n - 2 downTo 0) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1
            }
        }
        var result = minOf(right.max() + 1, n)
        var left = 1
        var i = 1
        while (i + 1 < n) {
            if (nums[i - 1] <= nums[i + 1]) {
                result = maxOf(result, left + 1 + right[i + 1])
            }
            if (nums[i - 1] <= nums[i]) {
                ++left
            } else {
                left = 1
            }
            ++i
        }
        return result
    }
}
