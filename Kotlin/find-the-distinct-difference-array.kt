package findthedistinctdifferencearray

// Time:  O(n)
// Space: O(n)
class Solution {
    fun distinctDifferenceArray(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        val lookup = hashSetOf<Int>()
        for (i in nums.indices) {
            lookup.add(nums[i])
            result[i] = lookup.size
        }
        lookup.clear()
        for (i in nums.size - 1 downTo 0) {
            result[i] -= lookup.size
            lookup.add(nums[i])
        }
        return result
    }
}
