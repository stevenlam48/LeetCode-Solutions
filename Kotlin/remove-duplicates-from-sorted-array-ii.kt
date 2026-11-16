package removeduplicatesfromsortedarrayii

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        val k = 2 // At most k duplicated.

        var left = 0
        var right = 1

        while (right < nums.size) {
            if (nums[left] != nums[right] ||
                (left - k + 1 < 0 || nums[left] != nums[left - k + 1])
            ) {
                ++left
                nums[left] = nums[right]
            }
            ++right
        }

        return left + 1
    }
}
