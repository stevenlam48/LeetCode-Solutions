package primesubsetselectioni

// Time:  precompute: O(r)
//        runtime:    O(min(n / logn, sqrt(s)))
// Space: O(r)

private const val MAX_N = 1_000_000

private val PRIMES: IntArray = linearSieveOfEratosthenes(MAX_N)

private fun linearSieveOfEratosthenes(n: Int): IntArray {
    val spf = IntArray(n + 1) { -1 }
    val primes = IntArray(n / 2)
    var count = 0
    for (i in 2..n) {
        if (spf[i] == -1) {
            spf[i] = i
            primes[count++] = i
        }
        for (k in 0 until count) {
            val p = primes[k]
            if (i * p > n || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    return primes.copyOf(count)
}

class Solution {
    fun maxPrimes(n: Int, s0: Int): IntArray {
        var s = s0
        val result = ArrayList<Int>()
        for (x in PRIMES) {
            if (x > n || s - x < 0) {
                break
            }
            s -= x
            result.add(x)
        }
        return result.toIntArray()
    }
}
