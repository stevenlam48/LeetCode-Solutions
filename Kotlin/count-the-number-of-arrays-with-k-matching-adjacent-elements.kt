package countthenumberofarrayswithkmatchingadjacentelements

// Time:  O(n + logm)
// Space: O(n)

// combinatorics, fast exponentiation
private const val MOD = 1_000_000_007
private val FACT = mutableListOf(1L, 1L)
private val INV = mutableListOf(1L, 1L)
private val INV_FACT = mutableListOf(1L, 1L)

private fun nCr(n: Int, k: Int): Int {
    while (INV.size <= n) {  // lazy initialization
        FACT.add((FACT.last() * INV.size) % MOD)
        INV.add((INV[MOD % INV.size] * (MOD - MOD / INV.size)) % MOD)
        INV_FACT.add((INV_FACT.last() * INV.last()) % MOD)
    }
    return (((FACT[n] * INV_FACT[n - k]) % MOD) * INV_FACT[k] % MOD).toInt()
}

class Solution {
    fun countGoodArrays(n: Int, m: Int, k: Int): Int {
        val powmod = { a0: Int, b0: Int ->
            var a = (a0 % MOD).toLong()
            var b = b0
            var result = 1L
            while (b != 0) {
                if (b and 1 != 0) {
                    result = result * a % MOD
                }
                a = a * a % MOD
                b = b shr 1
            }
            result
        }

        return (nCr(n - 1, k) * (m * powmod(m - 1, (n - 1) - k) % MOD) % MOD).toInt()
    }
}
