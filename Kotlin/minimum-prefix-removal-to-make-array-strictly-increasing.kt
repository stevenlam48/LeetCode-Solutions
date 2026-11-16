package minimumprefixremovaltomakearraystrictlyincreasing
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumPrefixLength(nums: IntArray): Int {
        for (i in nums.size - 2 downTo 0) {
            if (nums[i] >= nums[i + 1]) {
                return i + 1
            }
        }
        return 0
    }
}
