package concatenatearraywithreverse
// Time:  O(n)
// Space: O(1)

class Solution {
    fun concatWithReverse(nums: IntArray): IntArray {
        val result = IntArray(nums.size * 2)
        for (i in nums.indices) {
            result[i] = nums[i]
            result[result.size - 1 - i] = nums[i]
        }
        return result
    }
}
