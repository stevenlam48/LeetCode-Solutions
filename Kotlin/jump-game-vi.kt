package jumpgamevi
// Time:  O(n)
// Space: O(k)

import java.util.ArrayDeque

class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        var score = 0
        val dq = ArrayDeque<Pair<Int, Int>>()
        for (i in nums.indices) {
            if (dq.isNotEmpty() && dq.first().first == i - k - 1) {
                dq.removeFirst()
            }
            score = if (dq.isEmpty()) nums[i] else dq.first().second + nums[i]
            while (dq.isNotEmpty() && dq.last().second <= score) {
                dq.removeLast()
            }
            dq.addLast(i to score)
        }
        return score
    }
}
