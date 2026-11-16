package validelementsinanarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findValidElements(nums: IntArray): IntArray {
        val right = BooleanArray(nums.size)
        var mx = 0
        for (i in nums.size - 1 downTo 0) {
            right[i] = nums[i] > mx
            mx = maxOf(mx, nums[i])
        }
        val result = ArrayList<Int>()
        mx = 0
        for (i in nums.indices) {
            val left = nums[i] > mx
            mx = maxOf(mx, nums[i])
            if (left || right[i]) {
                result.add(nums[i])
            }
        }
        return result.toIntArray()
    }
}
