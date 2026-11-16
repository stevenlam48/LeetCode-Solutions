package handshakesthatdontcross

// Time:  O(n)
// Space: O(1)

class Solution {
    fun numberOfWays(numPeople: Int): Int {
        val MOD = 1000000007
        val n = numPeople / 2
        return (1L * nCr(2 * n, n, MOD) % MOD * inv(n + 1, MOD) % MOD).toInt()
    }

    private fun nCr(n: Int, kIn: Int, m: Int): Int {
        val k = if (n - kIn < kIn) n - kIn else kIn
        var result = 1L
        for (i in 1..k) {
            result = (result * (n - k + i) % m) * inv(i, m) % m
        }
        return result.toInt()
    }

    private fun inv(x: Int, m: Int): Int {
        return pow(x.toLong(), m - 2, m)
    }

    private fun pow(aIn: Long, bIn: Int, m: Int): Int {
        var a = aIn % m
        var b = bIn
        var result = 1L
        while (b != 0) {
            if ((b and 1) == 1) {
                result = (result * a) % m
            }
            a = (a * a) % m
            b = b shr 1
        }
        return result.toInt()
    }
}
