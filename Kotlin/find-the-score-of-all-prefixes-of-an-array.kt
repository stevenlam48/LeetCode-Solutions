package findthescoreofallprefixesofanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findPrefixScore(nums: IntArray): LongArray {
        val result = LongArray(nums.size)
        var curr = 0
        for (i in nums.indices) {
            curr = maxOf(curr, nums[i])
            result[i] = (if (i - 1 >= 0) result[i - 1] else 0L) + nums[i] + curr
        }
        return result
    }
}
