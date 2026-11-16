package zeroarraytransformationiv

// Time:  O(n^2 * r * logq), r = max(nums)
// Space: O(r)

// binary search, dp
class Solution {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        fun valid(arr: IntArray, target: Int): Boolean {
            val dp = BooleanArray(target + 1)
            dp[0] = true
            for (x in arr) {
                val newDp = BooleanArray(target + 1)
                for (j in 0..target) {
                    newDp[j] = dp[j] || (j - x >= 0 && dp[j - x])
                }
                newDp.copyInto(dp)
            }
            return dp[target]
        }

        fun check(l: Int): Boolean {
            for (i in nums.indices) {
                val arr = ArrayList<Int>()
                for (j in 0 until l) {
                    if (queries[j][0] <= i && i <= queries[j][1]) {
                        arr.add(queries[j][2])
                    }
                }
                if (!valid(arr.toIntArray(), nums[i])) {
                    return false
                }
            }
            return true
        }

        var left = 0
        var right = queries.size
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left <= queries.size) left else -1
    }
}
