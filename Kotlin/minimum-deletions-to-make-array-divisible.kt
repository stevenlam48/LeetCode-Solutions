package minimumdeletionstomakearraydivisible
// Time:  O(n + m + logr), r is max(numsDivide)
// Space: O(1)

class Solution {
    fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
        var g = numsDivide[0]
        for (x in numsDivide) {
            g = gcd(g, x)
        }
        var mn = Int.MAX_VALUE
        for (x in nums) {
            if (g % x == 0) {
                mn = minOf(mn, x)
            }
        }
        return if (mn != Int.MAX_VALUE) nums.count { it < mn } else -1
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return x
    }
}
