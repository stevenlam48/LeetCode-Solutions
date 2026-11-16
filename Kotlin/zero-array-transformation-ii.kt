package zeroarraytransformationii

// Time:  O((n + q) * logn)
// Space: O(n)

// binary search, line sweep
class Solution {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        fun check(k: Int): Boolean {
            val events = IntArray(nums.size + 1)
            for (i in 0 until k) {
                events[queries[i][0]] += queries[i][2]
                events[queries[i][1] + 1] -= queries[i][2]
            }
            var curr = 0
            for (i in nums.indices) {
                curr += events[i]
                if (nums[i] > curr) {
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
