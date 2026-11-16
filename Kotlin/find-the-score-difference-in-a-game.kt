package findthescoredifferenceinagame

// Time:  O(n)
// Space: O(1)

class Solution {
    fun scoreDifference(nums: IntArray): Int {
        var result = 0
        var sign = 1
        for (i in nums.indices) {
            if (nums[i] % 2 != 0) {
                sign *= -1
            }
            if (i % 6 == 5) {
                sign *= -1
            }
            result += sign * nums[i]
        }
        return result
    }
}
