package countcollisionsofmonkeysonapolygon

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun monkeyMove(n: Int): Int {
        val mod = 1_000_000_007L

        fun powmod(value: Int, exponent: Int): Long {
            var a = (value % mod).toLong()
            var b = exponent
            var result = 1L
            while (b != 0) {
                if (b and 1 != 0) {
                    result = result * a % mod
                }
                a = a * a % mod
                b = b shr 1
            }
            return result
        }

        return ((powmod(2, n) - 2 + mod) % mod).toInt()
    }
}
