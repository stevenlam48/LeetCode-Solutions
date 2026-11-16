package transformarraytoallequalelements
// Time:  O(n)
// Space: O(1)

class Solution {
    fun canMakeEqual(nums: IntArray, k: Int): Boolean {
        fun check(target: Int): Boolean {
            var cnt = 0
            var sign = 1
            for (i in nums.indices) {
                if (nums[i] * sign == target) {
                    sign = 1
                    continue
                }
                if (i + 1 == nums.size || ++cnt > k) {
                    return false
                }
                sign = -1
            }
            return true
        }
        return check(1) || check(-1)
    }
}
