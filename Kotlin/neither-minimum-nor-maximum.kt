package neitherminimumnormaximum
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findNonMinOrMax(nums: IntArray): Int {
        var mx = Int.MIN_VALUE
        var mn = Int.MAX_VALUE
        var result = -1
        for (x in nums) {
            if (mn < x && x < mx) {
                return x
            }
            if (x < mn) {
                result = mn
                mn = x
            }
            if (x > mx) {
                result = mx
                mx = x
            }
        }
        return if (mn < result && result < mx) result else -1
    }
}
