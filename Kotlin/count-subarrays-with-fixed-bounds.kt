package countsubarrayswithfixedbounds

// Time:  O(n)
// Space: O(1)

// two pointers
class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var result = 0L
        var left = 0
        val right = intArrayOf(-1, -1)
        for (i in nums.indices) {
            if (nums[i] < minK || nums[i] > maxK) {
                left = i + 1
                continue
            }
            if (nums[i] == minK) {
                right[0] = i
            }
            if (nums[i] == maxK) {
                right[1] = i
            }
            result += maxOf(minOf(right[0], right[1]) - left + 1, 0)
        }
        return result
    }
}
