package sumofabsolutedifferencesinasortedarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        var prefix = 0
        var suffix = nums.sum()
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            suffix -= nums[i]
            result[i] = (i * nums[i] - prefix) + (suffix - ((nums.size - 1) - i) * nums[i])
            prefix += nums[i]
        }
        return result
    }
}
