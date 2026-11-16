package sortingthreegroups

// Time:  O(k * n) = O(n)
// Space: O(k) = O(1)

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        val k = nums.size

        val dp = IntArray(k)
        for (x in nums) {
            ++dp[x - 1]
            for (i in x until dp.size) {
                dp[i] = maxOf(dp[i], dp[i - 1])
            }
        }
        return nums.size - dp.last()
    }
}
