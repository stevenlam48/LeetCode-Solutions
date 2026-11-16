package countgoodnumbers

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countGoodNumbers(n: Long): Int {
        val mod = 1000000007L
        return (powMod(5, (n + 1) / 2 % (mod - 1), mod) *
            powMod(4, n / 2 % (mod - 1), mod) % mod).toInt()
    }

    private fun powMod(a: Long, b: Long, mod: Long): Long {
        var base = a % mod
        var exponent = b
        var result = 1L
        while (exponent != 0L) {
            if (exponent and 1L != 0L) {
                result = result * base % mod
            }
            base = base * base % mod
            exponent = exponent shr 1
        }
        return result
    }
}
