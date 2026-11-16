package findsumofarrayproductofmagicalsequences

// Time:  O(n * k * m^2)
// Space: O(k * m^2)

// dp, combinatorics
class Solution {
    fun magicalSum(m: Int, k: Int, nums: IntArray): Int {
        while (inv_.size <= m) {
            fact_.add(mulmod(fact_.last(), inv_.size))
            inv_.add(mulmod(inv_[MOD % inv_.size], MOD - MOD / inv_.size))
            invFact_.add(mulmod(invFact_.last(), inv_.last()))
        }
        // dp[c][b][l]: sum of carry c with b set bits with remain size of l
        var dp = Array(m + 1) { Array(k + 1) { IntArray(m + 1) } }
        dp[0][0][m] = 1
        for (x in nums) {
            val newDp = Array(m + 1) { Array(k + 1) { IntArray(m + 1) } }
            for (c in 0..m) {
                for (b in 0..k) {
                    for (l in 0..m) {
                        if (dp[c][b][l] == 0) {
                            continue
                        }
                        var base = 1
                        for (cnt in 0..l) {
                            val nc = (c + cnt) shr 1
                            val nb = b + ((c + cnt) and 1)
                            val nl = l - cnt
                            if (nb > k) {
                                continue
                            }
                            newDp[nc][nb][nl] = addmod(newDp[nc][nb][nl], mulmod(mulmod(dp[c][b][l], base), invFact_[cnt]))
                            base = mulmod(base, x)
                        }
                    }
                }
            }
            dp = newDp
        }
        var result = 0
        for (c in 0..m) {
            val b = k - Integer.bitCount(c)
            if (b >= 0) {
                result = addmod(result, dp[c][b][0])
            }
        }
        result = mulmod(result, fact_[m])
        return result
    }

    private fun addmod(a: Int, b: Int): Int {
        return ((a.toLong() + b) % MOD).toInt()
    }

    private fun mulmod(a: Int, b: Int): Int {
        return (a.toLong() * b % MOD).toInt()
    }

    private val MOD = 1_000_000_007
    private val fact_ = mutableListOf(1, 1)
    private val inv_ = mutableListOf(1, 1)
    private val invFact_ = mutableListOf(1, 1)
}
