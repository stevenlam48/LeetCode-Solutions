package countpartitionswithmaxmindifferenceatmostk

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val mod = 1_000_000_007
        val maxDeque = ArrayDeque<Int>()
        val minDeque = ArrayDeque<Int>()
        val dp = IntArray(nums.size + 1)
        dp[0] = 1
        var left = 0
        var suffix = 0
        for (right in nums.indices) {
            suffix = (suffix + dp[right]) % mod
            while (maxDeque.isNotEmpty() && nums[maxDeque.last()] <= nums[right]) {
                maxDeque.removeLast()
            }
            maxDeque.addLast(right)
            while (minDeque.isNotEmpty() && nums[minDeque.last()] >= nums[right]) {
                minDeque.removeLast()
            }
            minDeque.addLast(right)
            while (nums[maxDeque.first()] - nums[minDeque.first()] > k) {
                if (maxDeque.first() == left) {
                    maxDeque.removeFirst()
                }
                if (minDeque.first() == left) {
                    minDeque.removeFirst()
                }
                suffix = (suffix - dp[left] + mod) % mod
                ++left
            }
            dp[right + 1] = suffix
        }
        return dp[nums.size]
    }
}
