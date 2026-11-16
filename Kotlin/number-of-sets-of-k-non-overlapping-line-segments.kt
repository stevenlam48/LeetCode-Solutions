package numberofsetsofknonoverlappinglinesegments

// Time:  O(1), excluding precomputation time
// Space: O(n)

class Solution() {
    private val fact_ = IntArray(2 * MAX_N - 1 + 1)
    private val inv_ = IntArray(2 * MAX_N - 1 + 1)
    private val invFact_ = IntArray(2 * MAX_N - 1 + 1)

    init {
        fact_[0] = 1
        invFact_[0] = 1
        fact_[1] = 1
        invFact_[1] = 1
        inv_[1] = 1
        for (i in 2 until fact_.size) {
            fact_[i] = mulmod(fact_[i - 1].toLong(), i.toLong()).toInt()
            inv_[i] = mulmod(inv_[MOD % i].toLong(), (MOD - MOD / i).toLong()).toInt()
            invFact_[i] = mulmod(invFact_[i - 1].toLong(), inv_[i].toLong()).toInt()
        }
    }

    fun numberOfSets(n: Int, k: Int): Int {
        // find k segments with 1+ length and (k+1) spaces with 0+ length s.t. total length is n-1
        // => find k segments with 0+ length and (k+1) spaces with 0+ length s.t. total length is n-k-1
        // => find the number of combinations of 2k+1 variables with total sum n-k-1
        // => H(2k+1, n-k-1)
        // => C((2k+1) + (n-k-1) - 1, n-k-1)
        // => C(n+k-1, n-k-1) = C(n+k-1, 2k)
        return nCr(n + k - 1, 2 * k, MOD)
    }

    private fun mulmod(aa: Long, bb: Long): Long {
        val a = aa % MOD
        val b = bb % MOD
        return a * b % MOD
    }

    private fun nCr(n: Int, k: Int, mod: Int): Int {
        return mulmod(
            mulmod(fact_[n].toLong(), invFact_[n - k].toLong()),
            invFact_[k].toLong()
        ).toInt()
    }

    companion object {
        private const val MOD = 1_000_000_007
        private const val MAX_N = 1000
    }
}
