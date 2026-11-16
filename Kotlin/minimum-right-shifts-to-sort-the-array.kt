package minimumrightshiftstosortthearray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumRightShifts(nums: IntArray): Int {
        var i = 0
        while (i < nums.size) {
            if (!(nums[i % nums.size] < nums[(i + 1) % nums.size])) {
                break
            }
            ++i
        }
        var j = i + 1
        while (j < nums.size) {
            if (!(nums[j % nums.size] < nums[(j + 1) % nums.size])) {
                break
            }
            ++j
        }
        return if (j == nums.size) nums.size - (i + 1) else -1
    }
}
