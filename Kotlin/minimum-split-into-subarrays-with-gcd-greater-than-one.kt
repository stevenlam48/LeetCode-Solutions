package minimumsplitintosubarrayswithgcdgreaterthanone

// Time:  O(nlogr), r = max(nums)
// Space: O(1)

class Solution {
    fun minimumSplits(nums: IntArray): Int {
        var result = 1
        var g = 0
        for (x in nums) {
            g = gcd(g, x)
            if (g == 1) {
                g = x
                ++result
            }
        }
        return result
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
