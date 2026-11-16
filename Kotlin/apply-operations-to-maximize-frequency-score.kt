package applyoperationstomaximizefrequencyscore

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maxFrequencyScore(nums: IntArray, k: Long): Int {
        nums.sort()
        var curr = 0L
        var right = 0
        var left = 0
        while (right < nums.size) {
            curr += (nums[right] - nums[(left + right) / 2]).toLong()
            if (curr > k) {
                curr -= (nums[(left + 1 + right) / 2] - nums[left++]).toLong()
            }
            ++right
        }
        return right - left
    }
}
