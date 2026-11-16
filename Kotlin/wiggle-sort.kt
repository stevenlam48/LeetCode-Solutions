package wigglesort

// Time:  O(n)
// Space: O(1)

class Solution {
    fun wiggleSort(nums: IntArray) {
        for (i in 1 until nums.size) {
            if (((i % 2) != 0 && nums[i] < nums[i - 1]) ||
                ((i % 2) == 0 && nums[i] > nums[i - 1])) {
                // Swap unordered elements.
                val tmp = nums[i]
                nums[i] = nums[i - 1]
                nums[i - 1] = tmp
            }
        }
    }
}
