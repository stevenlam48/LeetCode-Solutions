package waterandjugproblem

// Time:  O(logn), n is the max of (x, y)
// Space: O(1)

// Bézout's identity (also called Bézout's lemma)
class Solution {
    fun canMeasureWater(x: Int, y: Int, z: Int): Boolean {
        return z == 0 || (z <= x + y && z % gcd(x, y) == 0)
    }

    private fun gcd(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (b != 0) {
            val tmp = b
            b = a % b
            a = tmp
        }
        return a
    }
}
