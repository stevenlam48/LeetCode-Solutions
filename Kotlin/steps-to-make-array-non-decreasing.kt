package stepstomakearraynondecreasing

// Time:  O(n)
// Space: O(n)

class Solution {
    fun totalSteps(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        val stk = ArrayList<Int>()
        for (i in nums.size - 1 downTo 0) {
            while (stk.isNotEmpty() && nums[stk[stk.size - 1]] < nums[i]) {
                dp[i] = maxOf(dp[i] + 1, dp[stk[stk.size - 1]])
                stk.removeAt(stk.size - 1)
            }
            stk.add(i)
        }
        return dp.max()
    }
}
