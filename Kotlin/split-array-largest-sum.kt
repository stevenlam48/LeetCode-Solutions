package splitarraylargestsum
// Time:  O(nlogs), s is the sum of nums
// Space: O(1)

class Solution {
    fun splitArray(nums: IntArray, m: Int): Int {
        var left = nums.max().toLong()
        var right = nums.fold(0L) { acc, num -> acc + num }
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(nums, m, mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left.toInt()
    }

    private fun check(nums: IntArray, m: Int, total: Long): Boolean {
        var cnt = 1
        var currSum = 0L
        for (num in nums) {
            currSum += num
            if (currSum > total) {
                currSum = num.toLong()
                ++cnt
            }
        }
        return cnt <= m
    }
}
