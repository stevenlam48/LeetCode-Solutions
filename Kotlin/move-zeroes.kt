package movezeroes

// Time:  O(n)
// Space: O(1)

class Solution {
    fun moveZeroes(nums: IntArray) {
        var pos = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                val tmp = nums[pos]
                nums[pos] = nums[i]
                nums[i] = tmp
                ++pos
            }
        }
    }
}
