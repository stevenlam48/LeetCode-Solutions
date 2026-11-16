package longestsubarrayof1safterdeletingoneelement
// Time:  O(n)
// Space: O(1)

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var count = 0
        var left = 0
        var right = 0
        while (right < nums.size) {
            if (nums[right] == 0) {
                ++count
            }
            if (count >= 2) {
                if (nums[left++] == 0) {
                    --count
                }
            }
            ++right
        }
        return right - left - 1
    }
}
