package countgoodcyclicrotations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countGoodRotations(nums: IntArray): Int {
        var result = 0
        val total = nums.sumOf { it.toLong() }
        var curr = nums.take(nums.size / 2).sumOf { it.toLong() }
        for (i in nums.indices) {
            if (curr > total - curr) {
                ++result
            }
            curr += nums[(i + nums.size / 2) % nums.size] - nums[i]
        }
        return result
    }
}
