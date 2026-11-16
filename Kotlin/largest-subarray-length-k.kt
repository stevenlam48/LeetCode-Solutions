package largestsubarraylengthk

// Time:  O(n)
// Space: O(1)

class Solution {
    fun largestSubarray(nums: IntArray, k: Int): IntArray {
        var left = 0
        var right = 1
        var l = 0
        while (right + k - 1 < nums.size && right + l < nums.size) {
            if (nums[left + l] == nums[right + l]) {
                ++l
                continue
            }
            if (nums[left + l] > nums[right + l]) {
                right += l + 1
            } else {
                left = maxOf(right, minOf(left + l + 1, nums.size - k))
                right = left + 1
            }
            l = 0
        }
        return nums.copyOfRange(left, left + k)
    }
}
