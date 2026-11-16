package subsetsii

// Time:  O(n * 2^n)
// Space: O(1)

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf())
        nums.sort()
        var previousSize = 0
        for (i in nums.indices) {
            val size = result.size
            for (j in 0 until size) {
                // Only union non-duplicate element or new union set.
                if (i == 0 || nums[i] != nums[i - 1] || j >= previousSize) {
                    result.add(result[j].toMutableList())
                    result[result.size - 1].add(nums[i])
                }
            }
            previousSize = size
        }
        return result
    }
}
