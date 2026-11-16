package computealternatingsum
// Time:  O(n)
// Space: O(1)

class Solution {
    fun alternatingSum(nums: IntArray): Int {
        var result = 0
        var sign = 1
        for (x in nums) {
            result += sign * x
            sign *= -1
        }
        return result
    }
}
