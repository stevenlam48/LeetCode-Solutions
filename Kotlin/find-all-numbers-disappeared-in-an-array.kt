package findallnumbersdisappearedinanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        for (i in nums.indices) {
            val index = kotlin.math.abs(nums[i]) - 1
            if (nums[index] > 0) {
                nums[index] *= -1
            }
        }
        val result = ArrayList<Int>()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                result.add(i + 1)
            } else {
                nums[i] *= -1
            }
        }
        return result
    }
}
