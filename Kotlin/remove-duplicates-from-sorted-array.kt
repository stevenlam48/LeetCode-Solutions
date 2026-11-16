package removeduplicatesfromsortedarray

// Time:  O(n)
// Space: O(1)
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var last = -1
        for (num in nums) {
            if (last == -1 || nums[last] != num) {
                nums[++last] = num
            }
        }
        return last + 1
    }
}
