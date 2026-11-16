package applyoperationstoanarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        for (i in 0 until nums.size - 1) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
        }
        var i = 0
        for (x in nums) {
            if (x != 0) {
                nums[i++] = x
            }
        }
        while (i < nums.size) {
            nums[i++] = 0
        }
        return nums
    }
}
