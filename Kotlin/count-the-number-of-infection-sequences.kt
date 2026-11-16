package countthenumberofinfectionsequences

// Time:  precompute: O(max_n)
//        runtime:    O(s + logn)
// Space: O(max_n)

// combinatorics
private const val MOD = 1_000_000_007L
private val FACT = mutableListOf(1L, 1L)
private val INV = mutableListOf(1L, 1L)
private val INV_FACT = mutableListOf(1L, 1L)

private fun nCr(n: Int, k: Int): Long {
    while (INV.size <= n) {  // lazy initialization
        FACT.add(FACT.last() * INV.size % MOD)
        INV.add(INV[(MOD % INV.size).toInt()] * (MOD - MOD / INV.size) % MOD)
        INV_FACT.add(INV_FACT.last() * INV.last() % MOD)
    }
    return FACT[n] * INV_FACT[n - k] % MOD * INV_FACT[k] % MOD
}

private fun powmod(a0: Long, b0: Int): Long {
    var a = a0 % MOD
    var b = b0
    var result = 1L
    while (b != 0) {
        if (b and 1 != 0) {
            result = result * a % MOD
        }
        a = a * a % MOD
        b = b shr 1
    }
    return result
}

class Solution {
    fun numberOfSequence(n: Int, sick: IntArray): Int {
        var result = 1L
        var total = 0
        var cnt = 0
        for (i in 0..sick.size) {
            val l = (if (i < sick.size) sick[i] else n) -
                (if (i - 1 >= 0) sick[i - 1] else -1) - 1
            if (i != 0 && i != sick.size) {
                cnt += maxOf(l - 1, 0)
            }
            total += l
            result = result * nCr(total, l) % MOD
        }
        result = result * powmod(2, cnt) % MOD
        return result.toInt()
    }
}
