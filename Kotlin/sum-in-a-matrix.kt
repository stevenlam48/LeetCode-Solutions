package suminamatrix

// Time:  O(m * nlogn)
// Space: O(1)
class Solution {
    fun matrixSum(nums: Array<IntArray>): Int {
        for (row in nums) {
            row.sort()
        }
        var result = 0
        for (c in nums[0].indices) {
            var mx = 0
            for (r in nums.indices) {
                mx = maxOf(mx, nums[r][c])
            }
            result += mx
        }
        return result
    }
}
