package reshapethematrix

// Time:  O(m * n)
// Space: O(m * n)

class Solution {
    fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        if (nums.isEmpty() ||
            r * c != nums.size * nums[0].size) {
            return nums
        }

        val result = Array(r) { IntArray(c) }
        var count = 0
        for (i in nums.indices) {
            for (j in nums[0].indices) {
                result[count / c][count % c] = nums[i][j]
                ++count
            }
        }
        return result
    }
}
