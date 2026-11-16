package minimumcosttomakearrayequal
// Time:  O(nlogn)
// Space: O(n)

import kotlin.math.abs

class Solution {
    fun minCost(nums: IntArray, cost: IntArray): Long {
        fun f(x: Int): Long {
            var result = 0L
            for (i in nums.indices) {
                result += abs(nums[i] - x).toLong() * cost[i]
            }
            return result
        }

        fun check(x: Int, t: Long): Boolean {
            var cnt = 0L
            for (i in nums.indices) {
                if (nums[i] <= x) {
                    cnt += cost[i]
                }
            }
            return cnt >= t
        }

        val idxs = IntArray(nums.size) { it }
        val sortedIdxs = idxs.sortedBy { nums[it] }
        var left = 0
        var right = sortedIdxs.size - 1
        val total = cost.sumOf { it.toLong() }
        val median = (total + 1) / 2
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(nums[sortedIdxs[mid]], median)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return f(nums[sortedIdxs[left]])
    }
}
