package waystomakeafairarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun waysToMakeFair(nums: IntArray): Int {
        val prefix = IntArray(2)
        val suffix = IntArray(2)
        for (k in 0..1) {
            var i = k
            while (i < nums.size) {
                suffix[k] += nums[i]
                i += 2
            }
        }
        var result = 0
        for (i in nums.indices) {
            suffix[i % 2] -= nums[i]
            if (prefix[0] + suffix[1] == prefix[1] + suffix[0]) {
                ++result
            }
            prefix[i % 2] += nums[i]
        }
        return result
    }
}
