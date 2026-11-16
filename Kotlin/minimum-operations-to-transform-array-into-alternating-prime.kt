package minimumoperationstotransformarrayintoalternatingprime

// Time:  precompute: O(r)
//        runtime:    O(nlogr), prime gap is ln(r) on average
// Space: O(r)

private fun linearSieveOfEratosthenes(n: Int): Pair<List<Int>, IntArray> {
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
    return primes to spf
}

private const val MAX_NUMS = 100003
private val SIEVE = linearSieveOfEratosthenes(MAX_NUMS)
private val PRIMES = SIEVE.first
private val SPF = SIEVE.second

class Solution {
    fun minOperations(nums: IntArray): Int {
        var result = 0
        for (i in nums.indices) {
            var x = nums[i]
            if (i % 2 == 0) {
                while (SPF[x] != x) {
                    ++x
                    ++result
                }
            } else {
                while (SPF[x] == x) {
                    ++x
                    ++result
                }
            }
        }
        return result
    }
}
