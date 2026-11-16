package maximumerasurevalue

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        val lookup = HashMap<Int, Int>()
        val prefix = IntArray(nums.size + 1)
        var result = 0
        var left = 0
        for (right in nums.indices) {
            prefix[right + 1] = prefix[right] + nums[right]
            if (lookup.containsKey(nums[right])) {
                left = maxOf(left, lookup[nums[right]]!! + 1)
            }
            lookup[nums[right]] = right
            result = maxOf(result, prefix[right + 1] - prefix[left])
        }
        return result
    }
}
