package constrainedsubsetsum
// Time:  O(n)
// Space: O(k)

import java.util.ArrayDeque

class Solution {
    fun constrainedSubsetSum(nums: IntArray, k: Int): Int {
        var result = Int.MIN_VALUE
        val dq = ArrayDeque<Pair<Int, Int>>()
        for (i in nums.indices) {
            if (dq.isNotEmpty() && i - dq.first().first == k + 1) {
                dq.removeFirst()
            }
            val curr = nums[i] + if (dq.isNotEmpty()) dq.first().second else 0
            while (dq.isNotEmpty() && dq.last().second <= curr) {
                dq.removeLast()
            }
            if (curr > 0) {
                dq.addLast(i to curr)
            }
            result = maxOf(result, curr)
        }
        return result
    }
}
