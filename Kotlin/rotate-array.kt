package rotatearray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun rotate(nums: IntArray, k: Int) {
        if (nums.isNotEmpty()) {
            val shift = k % nums.size
            reverse(nums, 0, nums.size - shift)
            reverse(nums, nums.size - shift, nums.size)
            reverse(nums, 0, nums.size)
        }
    }

    private fun reverse(nums: IntArray, from: Int, to: Int) {
        var i = from
        var j = to - 1
        while (i < j) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            ++i
            --j
        }
    }
}
