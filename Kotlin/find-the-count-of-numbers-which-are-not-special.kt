package findthecountofnumberswhicharenotspecial

import kotlin.math.sqrt

// Time:  precompute:  O(sqrt(r))
//        runtime:     O(logr + log(sqrt(r))) = O(logr)
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

private const val MAX_R = 1_000_000_000
private val PRIMES = linearSieveOfEratosthenes(sqrt(MAX_R.toDouble()).toInt())

class Solution {
    fun nonSpecialCount(l: Int, r: Int): Int {
        return count(r) - count(l - 1)
    }

    private fun count(x: Int): Int {
        val root = sqrt(x.toDouble()).toInt()
        var left = 0
        var right = PRIMES.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (PRIMES[mid] <= root) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return x - left
    }
}
