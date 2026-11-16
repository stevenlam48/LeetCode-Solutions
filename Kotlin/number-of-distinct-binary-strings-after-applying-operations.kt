package numberofdistinctbinarystringsafterapplyingoperations

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun countDistinctStrings(s: String, k: Int): Int {
        val mod = 1_000_000_007
        return powmod(2, s.length - k + 1, mod)
    }

    private fun powmod(a: Int, b: Int, mod: Int): Int {
        var a = a % mod
        var b = b
        var result = 1L
        while (b != 0) {
            if ((b and 1) == 1) {
                result = result * a % mod
            }
            a = (a.toLong() * a % mod).toInt()
            b = b shr 1
        }
        return result.toInt()
    }
}
