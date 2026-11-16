package mergeoperationstoturnarrayintoapalindrome
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var result = 0
        var left = -1
        var right = nums.size
        var l = nums[++left].toLong()
        var r = nums[--right].toLong()
        while (left < right) {
            if (l == r) {
                l = nums[++left].toLong()
                r = nums[--right].toLong()
                continue
            }
            if (l < r) {
                l += nums[++left]
            } else {
                r += nums[--right]
            }
            ++result
        }
        return result
    }
}
