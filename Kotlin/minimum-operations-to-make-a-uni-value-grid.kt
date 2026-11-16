package minimumoperationstomakeaunivaluegrid

import kotlin.math.abs

// Time:  O(m * n) on average
// Space: O(m * n)

class Solution {
    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val nums = ArrayList<Int>()
        for (row in grid) {
            nums.addAll(row.toList())
        }
        var modGroup = -1
        for (num in nums) {
            if (modGroup == -1) {
                modGroup = num % x
            } else if (modGroup != num % x) {
                return -1
            }
        }
        nums.sort()
        val median = nums[nums.size / 2]
        var result = 0
        for (num in nums) {
            result += abs(num - median) / x
        }
        return result
    }
}
