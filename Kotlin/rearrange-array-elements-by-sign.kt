package rearrangearrayelementsbysign
// Time:  O(n)
// Space: O(1)
class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        var pos = 0
        var neg = 1
        val result = IntArray(nums.size)
        for (x in nums) {
            if (x > 0) {
                result[pos] = x
                pos += 2
            } else {
                result[neg] = x
                neg += 2
            }
        }
        return result
    }
}
