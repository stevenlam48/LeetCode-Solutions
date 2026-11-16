package checkifarrayissortedandrotated

// Time:  O(n)
// Space: O(1)

class Solution {
    fun check(nums: IntArray): Boolean {
        var count = 0
        for (i in nums.indices) {
            if (nums[i] > nums[(i + 1) % nums.size] && ++count > 1) {
                return false
            }
        }
        return true
    }
}
