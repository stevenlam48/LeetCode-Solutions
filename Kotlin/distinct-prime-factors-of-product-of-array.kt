package distinctprimefactorsofproductofarray
// Time:  precompute: O(sqrt(MAX_N))
//        runtime:    O(m + nlog(logn)), m = len(nums), n = max(nums)
// Space: O(sqrt(MAX_N))

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

private const val MAX_N = 1000
private val PRIMES = linearSieveOfEratosthenes(kotlin.math.sqrt(MAX_N.toDouble()).toInt())

class Solution {
    fun distinctPrimeFactors(nums: IntArray): Int {
        val result = mutableSetOf<Int>()
        for (original in nums.toSet()) {
            var x = original
            for (p in PRIMES) {
                if (p > x) {
                    break
                }
                if (x % p != 0) {
                    continue
                }
                result.add(p)
                while (x % p == 0) {
                    x /= p
                }
            }
            if (x != 1) {
                result.add(x)
            }
        }
        return result.size
    }
}
