package findmaximumnondecreasingarraylength

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMaximumLength(nums: IntArray): Int {
        var dp = 0
        var prefix = 0L
        val stk = mutableListOf(longArrayOf(0L, 0L, 0L))
        var left = 0
        for (right in nums.indices) {
            prefix += nums[right]
            while (left + 1 < stk.size && stk[left + 1][0] <= prefix) {
                ++left
            }
            val last = prefix - stk[left][1]
            dp = stk[left][2].toInt() + 1
            while (stk.isNotEmpty() && stk[stk.size - 1][0] >= last + prefix) {
                stk.removeAt(stk.size - 1)
            }
            stk.add(longArrayOf(last + prefix, prefix, dp.toLong()))
            left = minOf(left, stk.size - 1)
        }
        return dp
    }
}
