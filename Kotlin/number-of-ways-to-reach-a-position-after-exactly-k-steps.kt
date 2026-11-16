package numberofwaystoreachapositionafterexactlyksteps

// Time:  O(k)
// Space: O(k)

class Solution {
    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        val r = k - kotlin.math.abs(endPos - startPos)
        return if (r >= 0 && r % 2 == 0) nCr(k, r / 2) else 0
    }

    private fun nCr(n: Int, k: Int): Int {
        while (inv.size <= n) {
            fact.add(mulmod(fact.last(), inv.size))
            inv.add(mulmod(inv[mod % inv.size], mod - mod / inv.size))
            invFact.add(mulmod(invFact.last(), inv.last()))
        }
        return mulmod(mulmod(fact[n], invFact[n - k]), invFact[k])
    }

    private fun addmod(aValue: Int, bValue: Int): Int {
        val a = aValue % mod
        var b = bValue % mod
        if (mod - a <= b) {
            b -= mod
        }
        return a + b
    }

    private fun mulmod(aValue: Int, bValue: Int): Int {
        var a = aValue % mod
        var b = bValue % mod
        var result = 0
        if (a < b) {
            val temporary = a
            a = b
            b = temporary
        }
        while (b > 0) {
            if (b % 2 == 1) {
                result = addmod(result, a)
            }
            a = addmod(a, a)
            b /= 2
        }
        return result
    }

    private val mod = 1_000_000_007
    private val fact = mutableListOf(1, 1)
    private val inv = mutableListOf(1, 1)
    private val invFact = mutableListOf(1, 1)
}
