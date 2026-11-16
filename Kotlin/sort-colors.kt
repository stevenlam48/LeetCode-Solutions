package sortcolors

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortColors(nums: IntArray) {
        val target = 1
        var i = 0
        var left = 0
        var right = nums.size - 1
        while (i <= right) {
            if (nums[i] > target) {
                val temp = nums[i]
                nums[i] = nums[right]
                nums[right] = temp
                --right
            } else {
                if (nums[i] < target) {
                    val temp = nums[left]
                    nums[left] = nums[i]
                    nums[i] = temp
                    ++left
                }
                ++i
            }
        }
    }
}
