package jumpgameix
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxValue(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = nums[0]
        for (i in 0 until nums.size - 1) {
            result[i + 1] = maxOf(result[i], nums[i + 1])
        }
        var mn = Int.MAX_VALUE
        for (i in nums.size - 1 downTo 0) {
            if (result[i] > mn) {
                result[i] = result[i + 1]
            }
            mn = minOf(mn, nums[i])
        }
        return result
    }
}
