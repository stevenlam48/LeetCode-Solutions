package binarydigitscore

// Time:  O(log(logn)) = O(1)
// Space: O(1)

class Solution {
    fun calculateScore(a: Int, b: Int): Int {
        fun popcount(n0: Int): Int {
            var n = n0
            n = (n and 0x55555555) + ((n shr 1) and 0x55555555)
            n = (n and 0x33333333) + ((n shr 2) and 0x33333333)
            n = (n and 0x0F0F0F0F) + ((n shr 4) and 0x0F0F0F0F)
            n = (n and 0x00FF00FF) + ((n shr 8) and 0x00FF00FF)
            n = (n and 0x0000FFFF) + ((n shr 16) and 0x0000FFFF)
            return n
        }

        val s1 = popcount(a)
        val s2 = popcount(b)
        return if (s1 >= s2) s1 * s2 else s2 / s1
    }
}
