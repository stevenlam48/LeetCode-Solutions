package maximumarrayhoppingscoreii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxScore(nums: IntArray): Long {
        var result = 0L
        var mx = 0
        for (i in nums.size - 1 downTo 1) {
            mx = maxOf(mx, nums[i])
            result += mx
        }
        return result
    }
}
