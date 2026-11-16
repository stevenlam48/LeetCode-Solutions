package manhattandistancesofallarrangementsofpieces

// Time:  precompute: O(max(m * n))
//        runtime:    O(1)
// Space: O(max(m * n))

// combinatorics
private const val MOD = 1_000_000_007L

private fun addmod(a: Long, b: Long): Long {
    return ((a % MOD) + (b % MOD)) % MOD
}

private fun mulmod(a: Long, b: Long): Long {
    return (a % MOD) * (b % MOD) % MOD
}

private val FACT = mutableListOf(1L, 1L)
private val INV = mutableListOf(1L, 1L)
private val INV_FACT = mutableListOf(1L, 1L)

private fun nCr(n: Int, k: Int): Long {
    while (INV.size <= n) {
        FACT.add(mulmod(FACT.last(), INV.size.toLong()))
        INV.add(mulmod(INV[(MOD % INV.size).toInt()], MOD - MOD / INV.size))
        INV_FACT.add(mulmod(INV_FACT.last(), INV.last()))
    }
    return mulmod(mulmod(FACT[n], INV_FACT[n - k]), INV_FACT[k])
}

class Solution {
    fun distanceSum(m: Int, n: Int, k: Int): Int {
        fun sumN(x: Int): Long {
            return (x + 1L) * x / 2
        }

        fun sumNSquare(x: Int): Long {
            return x.toLong() * (x + 1) * (2 * x + 1) / 6
        }

        fun f(x: Int): Long {
            return x * sumN(x - 1) - sumNSquare(x - 1)
        }

        val x = mulmod(mulmod(f(n) % MOD, m.toLong()), m.toLong())
        val y = mulmod(mulmod(f(m) % MOD, n.toLong()), n.toLong())
        return mulmod(addmod(x, y), nCr(m * n - 2, k - 2)).toInt()
    }
}
