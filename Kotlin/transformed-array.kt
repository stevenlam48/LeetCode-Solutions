package transformedarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun constructTransformedArray(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)
        for (i in 0 until n) {
            result[i] = nums[((i + nums[i]) % n + n) % n]
        }
        return result
    }
}
