package largestprimefromconsecutiveprimesum

// Time:  precompute: O(sqrt(r) * sqrt(r)) = O(r)
//        runtime:    O(logp), p = len(PRIMES)
// Space: O(sqrt(r))

// precompute, number theory, binary search
private fun isPrime(n: Int): Boolean {
    if (n <= 1 || (n != 2 && n % 2 == 0)) {
        return false
    }
    var i = 3
    while (i <= n) {
        if (i * i > n) {
            break
        }
        if (n % i == 0) {
            return false
        }
        i += 2
    }
    return true
}

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
    return Pair(primes, spf)
}

private fun precompute(n: Int, sqrtN: Int): List<Int> {
    val (primes, spf) = linearSieveOfEratosthenes(sqrtN)
    val result = mutableListOf(0)
    var total = 0
    for (p in primes) {
        total += p
        if (total > n) {
            break
        }
        if ((total < spf.size && spf[total] == total) || isPrime(total)) {
            result.add(total)
        }
    }
    return result
}

private const val MAX_NUM = 500000
private const val SQRT_MAX_NUM = 2729
private val PRIMES = precompute(MAX_NUM, SQRT_MAX_NUM)

class Solution {
    fun largestPrime(n: Int): Int {
        var lo = 0
        var hi = PRIMES.size
        while (lo < hi) {
            val mid = (lo + hi) / 2
            if (PRIMES[mid] <= n) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return PRIMES[lo - 1]
    }
}
