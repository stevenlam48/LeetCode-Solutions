package mirrordistanceofaninteger

// Time:  O(logn)
// Space: O(1)

// math
class Solution {
    fun mirrorDistance(n: Int): Int {
        fun reverse(x0: Int): Int {
            var x = x0
            var result = 0
            while (x != 0) {
                result = result * 10 + x % 10
                x /= 10
            }
            return result
        }

        return Math.abs(n - reverse(n))
    }
}
