package maximumstrengthofagroup

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxStrength(nums: IntArray): Long {
        if (nums.all { it <= 0 } && nums.count { it < 0 } <= 1) {
            return nums.max().toLong()
        }
        var result = 1L
        for (x in nums) {
            if (x != 0) {
                result *= x
            }
        }
        var mx = Int.MIN_VALUE
        for (x in nums) {
            if (x < 0) {
                mx = maxOf(mx, x)
            }
        }
        return if (result > 0) result else result / mx
    }
}
