package p132pattern

// Time:  O(n)
// Space: O(n)

class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        var ak = Int.MIN_VALUE
        val stk = ArrayDeque<Int>()
        for (i in nums.indices.reversed()) {
            if (nums[i] < ak) {
                return true
            }
            while (stk.isNotEmpty() && stk.last() < nums[i]) {
                ak = stk.last()
                stk.removeLast()
            }
            stk.addLast(nums[i])
        }
        return false
    }
}
