package numberofsubsequencesthatsatisfythegivensumcondition
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    private fun powMod(base: Long, exponent: Int, mod: Long): Long {
        var a = base % mod
        var b = exponent
        var result = 1L
        while (b > 0) {
            if (b and 1 == 1) {
                result = result * a % mod
            }
            a = a * a % mod
            b = b shr 1
        }
        return result
    }

    fun numSubseq(nums: IntArray, target: Int): Int {
        val mod = 1_000_000_007L
        nums.sort()
        var result = 0L
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                --right
            } else {
                result = (result + powMod(2, right - left, mod)) % mod
                ++left
            }
        }
        return result.toInt()
    }
}
