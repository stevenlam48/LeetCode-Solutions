package numberofstringswhichcanberearrangedtocontainsubstring
// Time:  O(logn)
// Space: O(1)

class Solution {
    private val mod = 1_000_000_007L

    private fun powMod(base: Long, exponent: Long): Long {
        var a = base % mod
        var b = exponent
        var result = 1L
        while (b > 0) {
            if (b and 1L == 1L) {
                result = result * a % mod
            }
            a = a * a % mod
            b = b shr 1
        }
        return result
    }

    fun stringCount(n: Int): Int {
        val result = ((powMod(26, n.toLong()) -
                (75L + n) * powMod(25, (n - 1).toLong()) +
                (72L + 2L * n) * powMod(24, (n - 1).toLong()) -
                (23L + n) * powMod(23, (n - 1).toLong())) % mod + mod) % mod
        return result.toInt()
    }
}
