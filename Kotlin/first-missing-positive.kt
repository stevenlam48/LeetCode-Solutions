package firstmissingpositive

// Time:  O(n)
// Space: O(1)

class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        for (i in nums.indices) {
            while (1 <= nums[i] && nums[i] <= nums.size && nums[nums[i] - 1] != nums[i]) {
                val j = nums[i] - 1
                val tmp = nums[j]
                nums[j] = nums[i]
                nums[i] = tmp
            }
        }
        for (i in nums.indices) {
            if (nums[i] != i + 1) {
                return i + 1
            }
        }
        return nums.size + 1
    }
}
