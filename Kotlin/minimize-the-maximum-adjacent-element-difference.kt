package minimizethemaximumadjacentelementdifference
// Time:  O(nlogr)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun minDifference(nums: IntArray): Int {
        var maxDiff = 0
        for (i in 0 until nums.size - 1) {
            if (nums[i] != -1 && nums[i + 1] != -1) {
                maxDiff = maxOf(maxDiff, abs(nums[i] - nums[i + 1]))
            }
        }
        var left = Int.MAX_VALUE
        var right = 0
        for (i in nums.indices) {
            if (nums[i] != -1) {
                continue
            }
            if (i - 1 >= 0 && nums[i - 1] != -1) {
                left = minOf(left, nums[i - 1])
                right = maxOf(right, nums[i - 1])
            }
            if (i + 1 < nums.size && nums[i + 1] != -1) {
                left = minOf(left, nums[i + 1])
                right = maxOf(right, nums[i + 1])
            }
        }

        fun check(d: Int): Boolean {
            var cnt = 0
            var prev = 0
            val x = left + d
            val y = right - d
            for (num in nums) {
                if (num == -1) {
                    ++cnt
                    continue
                }
                if (prev != 0 && cnt != 0) {
                    val diff = minOf(
                        maxOf(abs(prev - x), abs(num - x)),
                        maxOf(abs(prev - y), abs(num - y))
                    )
                    if (diff > d && (cnt == 1 || y - x > d)) {
                        return false
                    }
                }
                prev = num
                cnt = 0
            }
            return true
        }

        var low = maxDiff
        var high = (right - left) / 2
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (check(mid)) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return low
    }
}
