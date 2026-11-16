package arithmeticsubarrays

// Time:  O(n * q)
// Space: O(n)

class Solution {
    fun checkArithmeticSubarrays(nums: IntArray, l: IntArray, r: IntArray): BooleanArray {
        val result = BooleanArray(l.size)
        for (i in l.indices) {
            result[i] = isArith(nums.copyOfRange(l[i], r[i] + 1))
        }
        return result
    }

    private fun isArith(nums: IntArray): Boolean {
        val lookup = nums.toHashSet()
        val mn = nums.min()
        val mx = nums.max()
        if (mx == mn) {
            return true
        }
        if ((mx - mn) % (nums.size - 1) != 0) {
            return false
        }
        val d = (mx - mn) / (nums.size - 1)
        var i = mn
        while (i <= mx) {
            if (i !in lookup) {
                return false
            }
            i += d
        }
        return true
    }
}
