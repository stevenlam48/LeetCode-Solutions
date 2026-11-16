package minimizethemaximumdifferenceofpairs
// Time:  O(nlogn + nlogr), r = max(nums)-min(nums)
// Space: O(1)

class Solution {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        fun check(x: Int): Boolean {
            var cnt = 0
            var i = 0
            while (i + 1 < nums.size && cnt < p) {
                if (nums[i + 1] - nums[i] <= x) {
                    ++i
                    ++cnt
                }
                ++i
            }
            return cnt == p
        }

        nums.sort()
        var left = 0
        var right = nums.last() - nums.first()
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}
