package minimizethemaximumvalueofgcdconnectedarray

// Time:  precompute: O(sqrt(r))
//        runtime:    O(sqrt(n) / logn)
// Space: O(sqrt(r))

private fun linearSieveOfEratosthenes(n: Int): List<Int> {
    val spf = IntArray(n + 1) { -1 }
    val primes = mutableListOf<Int>()
    for (i in 2..n) {
        if (spf[i] == -1) {
            spf[i] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i * p > n || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    return primes
}

private const val MAX_N = 1_000_000_000
private val PRIMES = linearSieveOfEratosthenes(Math.sqrt(MAX_N.toDouble()).toInt())

class Solution {
    fun minimumMaxValue(n: Int, index: Int, value: Int): Long {
        if (value == 1) {
            return -1
        }
        var x = value
        for (p in PRIMES) {
            if (p * p > value) {
                break
            }
            if (value % p == 0) {
                x = p
                break
            }
        }
        if (value - x - 2 * (index - 1) < 2) {
            return -1
        }
        return if (index != n - 1) value + x + 2L * ((n - 1) - index - 1) else value.toLong()
    }
}
