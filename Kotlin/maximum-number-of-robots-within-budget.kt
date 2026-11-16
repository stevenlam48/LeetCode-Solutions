package maximumnumberofrobotswithinbudget

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumRobots(chargeTimes: IntArray, runningCosts: IntArray, budget: Long): Int {
        val dq = java.util.ArrayDeque<Int>()
        var curr = 0L
        var left = 0
        var right = 0
        while (right < chargeTimes.size) {
            while (dq.isNotEmpty() && chargeTimes[dq.peekLast()] <= chargeTimes[right]) {
                dq.pollLast()
            }
            dq.addLast(right)
            curr += runningCosts[right]
            if (chargeTimes[dq.peekFirst()] + (right - left + 1) * curr > budget) {
                if (dq.peekFirst() == left) {
                    dq.pollFirst()
                }
                curr -= runningCosts[left]
                ++left
            }
            ++right
        }
        return right - left
    }
}
