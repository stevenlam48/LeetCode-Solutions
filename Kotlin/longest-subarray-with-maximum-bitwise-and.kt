package longestsubarraywithmaximumbitwiseand
// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val maximum = nums.max()
        var result = 1
        var length = 0
        for (x in nums) {
            if (x == maximum) {
                result = maxOf(result, ++length)
            } else {
                length = 0
            }
        }
        return result
    }
}
