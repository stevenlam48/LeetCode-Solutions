package findthenumberofkevenarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun countOfArrays(n: Int, m: Int, k: Int): Int {
        val even = m / 2
        val odd = (m + 1) / 2
        var result = 0
        if (k == 0) {
            result = (result + pow(odd, n)) % MOD
        }
        for (x in 1..(n + 1 - k) / 2) {
            val a = nHr(x, (k + x) - x).toLong() *
                nHr(x + 1, (n - (k + x)) - ((x + 1) - 2)) % MOD
            val b = pow(even, k + x).toLong() * pow(odd, n - (k + x)) % MOD
            result = (result + (a * b % MOD).toInt()) % MOD
        }
        return result
    }

    private fun nHr(n: Int, k: Int): Int {
        return nCr(n + k - 1, k)
    }

    private fun nCr(n: Int, k: Int): Int {
        while (inv.size <= n) {
            fact.add(mulmod(fact.last().toUInt(), inv.size.toUInt()).toInt())
            inv.add(
                mulmod(
                    inv[MOD % inv.size].toUInt(),
                    (MOD - MOD / inv.size).toUInt()
                ).toInt()
            )
            invFact.add(mulmod(invFact.last().toUInt(), inv.last().toUInt()).toInt())
        }
        return mulmod(
            mulmod(fact[n].toUInt(), invFact[n - k].toUInt()),
            invFact[k].toUInt()
        ).toInt()
    }

    private fun addmod(a: UInt, b: UInt): UInt {
        var x = a % MOD.toUInt()
        var y = b % MOD.toUInt()
        if (MOD.toUInt() - x <= y) {
            y -= MOD.toUInt()
        }
        return x + y
    }

    private fun mulmod(a: UInt, b: UInt): UInt {
        var x = a % MOD.toUInt()
        var y = b % MOD.toUInt()
        var result = 0u
        if (x < y) {
            val temp = x
            x = y
            y = temp
        }
        while (y > 0u) {
            if (y % 2u == 1u) {
                result = addmod(result, x)
            }
            x = addmod(x, x)
            y /= 2u
        }
        return result
    }

    private fun pow(a: Int, b: Int): Int {
        val powers = pow.getOrPut(a) { mutableListOf() }
        while (b >= powers.size) {
            powers.add(if (powers.isNotEmpty()) (powers.last().toLong() * a % MOD).toInt() else 1)
        }
        return powers[b]
    }

    private val fact = mutableListOf(1, 1)
    private val inv = mutableListOf(1, 1)
    private val invFact = mutableListOf(1, 1)
    private val pow = mutableMapOf<Int, MutableList<Int>>()

    private companion object {
        const val MOD = 1_000_000_007
    }
}
