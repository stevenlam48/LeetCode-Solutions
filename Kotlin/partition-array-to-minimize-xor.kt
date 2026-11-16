package partitionarraytominimizexor

// Time:  O(n^2 * k)
// Space: O(n)

class Solution {
    fun minXor(nums: IntArray, k: Int): Int {
        val inf = Int.MAX_VALUE
        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] xor nums[i]
        }
        val dp = prefix.copyOf()
        dp[0] = inf
        for (l in 2..k) {
            for (i in nums.size downTo l - 1) {
                var mn = inf
                for (j in l - 1 until i) {
                    val v = prefix[i] xor prefix[j]
                    val mx = maxOf(dp[j], v)
                    if (mx < mn) {
                        mn = mx
                    }
                }
                dp[i] = mn
            }
        }
        return dp[nums.size]
    }
}
