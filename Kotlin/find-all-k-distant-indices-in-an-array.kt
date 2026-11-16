package findallkdistantindicesinanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findKDistantIndices(nums: IntArray, key: Int, k: Int): List<Int> {
        val result = mutableListOf<Int>()
        var prev = -1
        for (i in nums.indices) {
            if (nums[i] != key) {
                continue
            }
            var j = maxOf(i - k, prev + 1)
            while (j <= minOf(i + k, nums.size - 1)) {
                result.add(j)
                ++j
            }
            prev = minOf(i + k, nums.size - 1)
        }
        return result
    }
}
