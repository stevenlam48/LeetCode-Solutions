package jumpgame

// Time:  O(n)
// Space: O(1)

class Solution {
    fun canJump(nums: IntArray): Boolean {
        var reachable = 0
        var i = 0
        while (i <= reachable && i < nums.size) {
            reachable = maxOf(reachable, i + nums[i])
            ++i
        }
        return reachable >= nums.size - 1
    }
}
