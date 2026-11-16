package trionicarrayii
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxSumTrionic(nums: IntArray): Long {
        var result = Long.MIN_VALUE
        var left = 0
        var p = 0
        var q = 0
        var prefix = nums[0].toLong()
        for (right in 1 until nums.size) {
            prefix += nums[right]
            if (nums[right - 1] > nums[right]) {
                if (right - 2 >= 0 && nums[right - 2] < nums[right - 1]) {
                    p = right - 1
                    while (left < q || (nums[left] < 0 && left + 1 < p)) {
                        prefix -= nums[left++]
                    }
                }
            } else if (nums[right - 1] < nums[right]) {
                if (right - 2 >= 0 && nums[right - 2] > nums[right - 1]) {
                    q = right - 1
                }
                if (left != p) {
                    result = maxOf(result, prefix)
                }
            } else {
                left = right
                p = right
                q = right
                prefix = nums[right].toLong()
            }
        }
        return result
    }
}
