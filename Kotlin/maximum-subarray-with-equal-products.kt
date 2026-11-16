package maximumsubarraywithequalproducts
// Time:  precompute: O(r * log(logr)), r = MAX_NUM
//        runtime:    O(n * log(logr))
// Space: O(r * log(logr))

private const val MAX_NUM = 10
private val PRIME_DIVISORS = primeDivisors(MAX_NUM)

private fun primeDivisors(n: Int): Array<MutableList<Int>> {
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
    val result = Array(n + 1) { mutableListOf<Int>() }
    for (p in primes) {
        var i = p
        while (i <= n) {
            result[i].add(p)
            i += p
        }
    }
    return result
}

class Solution {
    fun maxLength(nums: IntArray): Int {
        var result = 2
        val lookup = HashMap<Int, Int>()
        var left = 0
        for (right in nums.indices) {
            for (p in PRIME_DIVISORS[nums[right]]) {
                left = maxOf(left, lookup[p] ?: 0)
                lookup[p] = right + 1
            }
            result = maxOf(result, right - left + 1)
        }
        return result
    }
}
