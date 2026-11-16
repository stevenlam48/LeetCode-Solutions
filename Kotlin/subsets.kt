package subsets

// Time: O(n * 2^n)
// Space: O(1)

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf())
        nums.sort()
        for (i in nums.indices) {
            val size = result.size
            for (j in 0 until size) {
                result.add(result[j].toMutableList())
                result[result.size - 1].add(nums[i])
            }
        }
        return result
    }
}
