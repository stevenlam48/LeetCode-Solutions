package sumofincreasingproductblocks

// Time:  O(n^2)
// Space: O(n^2)

// simulation, math
private const val MOD = 1_000_000_007
private val FACT = mutableListOf(1, 1)
private val INV = mutableListOf(1, 1)
private val INV_FACT = mutableListOf(1, 1)

private fun lazyInit(n: Int) {
    while (INV.size <= n) {  // lazy initialization
        val s = INV.size
        FACT.add((FACT.last().toLong() * s % MOD).toInt())
        INV.add((INV[MOD % s].toLong() * (MOD - MOD / s) % MOD).toInt())
        INV_FACT.add((INV_FACT.last().toLong() * INV.last() % MOD).toInt())
    }
}

private fun factorial(n: Int): Int {
    lazyInit(n)
    return FACT[n]
}

private fun invFactorial(n: Int): Int {
    lazyInit(n)
    return INV_FACT[n]
}

class Solution {
    fun sumOfBlocks(n: Int): Int {
        var result = 0L
        var left = 1
        for (l in 0 until n) {
            val right = left + l
            result = (result + (factorial(right).toLong() * invFactorial(left - 1) % MOD)) % MOD
            left = right + 1
        }
        return result.toInt()
    }
}
