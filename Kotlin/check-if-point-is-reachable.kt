package checkifpointisreachable

// Time:  O(log(min(a, b)))
// Space: O(1)
class Solution {
    fun isReachable(targetX: Int, targetY: Int): Boolean {
        val g = gcd(targetX, targetY)
        return g == (g and (g - 1).inv())
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val remainder = x % y
            x = y
            y = remainder
        }
        return if (x < 0) -x else x
    }
}
