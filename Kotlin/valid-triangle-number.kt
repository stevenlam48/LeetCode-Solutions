package validtrianglenumber

// Time:  O(n^2)
// Space: O(1)

class Solution {
    fun triangleNumber(nums: IntArray): Int {
        var result = 0
        nums.sort()
        for (i in nums.size - 1 downTo 2) {
            var left = 0
            var right = i - 1
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += right - left
                    --right
                } else {
                    ++left
                }
            }
        }
        return result
    }
}
