package numberofselfdivisiblepermutations

// Time:  O(n^2 * logn + n * 2^n) = O(n * 2^n)
// Space: O(n^2 + 2^n) = O(2^n)

// bitmasks, dp
class Solution {
    fun selfDivisiblePermutationCount(n: Int): Int {
        val lookup = Array(n) { BooleanArray(n) }
        for (i in 0 until n) {
            for (j in i until n) {
                lookup[i][j] = gcd(i + 1, j + 1) == 1
                lookup[j][i] = lookup[i][j]
            }
        }
        val dp = IntArray(1 shl n)
        dp[0] = 1
        for (mask in 0 until (1 shl n)) {
            val i = Integer.bitCount(mask)
            for (j in 0 until n) {
                if (mask and (1 shl j) == 0 && lookup[i][j]) {
                    dp[mask or (1 shl j)] += dp[mask]
                }
            }
        }
        return dp.last()
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
