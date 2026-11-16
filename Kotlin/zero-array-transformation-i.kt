package zeroarraytransformationi

// Time:  O(n + q)
// Space: O(n)

// line sweep
class Solution {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val events = IntArray(nums.size + 1)
        for (q in queries) {
            ++events[q[0]]
            --events[q[1] + 1]
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
}
