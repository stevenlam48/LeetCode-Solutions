package nextpermutation
// Time:  O(n)
// Space: O(1)

class Solution {
    fun nextPermutation(nums: IntArray) {
        var pivot = -1
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] < nums[i + 1]) {
                pivot = i
                break
            }
        }
        if (pivot == -1) {
            reverse(nums, 0)
            return
        }
        for (i in nums.lastIndex downTo pivot + 1) {
            if (nums[i] > nums[pivot]) {
                val temp = nums[pivot]
                nums[pivot] = nums[i]
                nums[i] = temp
                break
            }
        }
        reverse(nums, pivot + 1)
    }

    private fun reverse(nums: IntArray, start: Int) {
        var left = start
        var right = nums.lastIndex
        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            ++left
            --right
        }
    }
}
