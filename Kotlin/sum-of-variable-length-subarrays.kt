package sumofvariablelengthsubarrays

// Time:  O(n)
// Space: O(n)

// difference array
class Solution {
    fun subarraySum(nums: IntArray): Int {
        val diff = IntArray(nums.size + 1)
        for (i in nums.indices) {
            ++diff[maxOf(i - nums[i], 0)]
            --diff[i + 1]
        }
        for (i in nums.indices) {
            diff[i + 1] += diff[i]
        }
        var result = 0
        for (i in nums.indices) {
            result += nums[i] * diff[i]
        }
        return result
    }
}
