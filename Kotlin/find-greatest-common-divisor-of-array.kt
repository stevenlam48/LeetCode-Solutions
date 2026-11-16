package findgreatestcommondivisorofarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findGCD(nums: IntArray): Int {
        return gcd(nums.min(), nums.max())
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
