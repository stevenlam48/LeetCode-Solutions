package primeindiagonal

// Time:  precompute: O(MAX_N)
//        runtime: O(n)
// Space: O(MAX_N)

private const val MAX_N = 4_000_000

private val PRIMES_SET: HashSet<Int> = run {
    val spf = IntArray(MAX_N + 1) { -1 }
    val primes = IntArray(MAX_N / 2)
    var count = 0
    for (i in 2..MAX_N) {
        if (spf[i] == -1) {
            spf[i] = i
            primes[count++] = i
        }
        for (k in 0 until count) {
            val p = primes[k]
            if (i * p > MAX_N || p > spf[i]) {
                break
            }
            spf[i * p] = p
        }
    }
    val result = HashSet<Int>(count * 2)
    for (k in 0 until count) {
        result.add(primes[k])
    }
    result
}

class Solution {
    fun diagonalPrime(nums: Array<IntArray>): Int {
        var result = 0
        for (i in nums.indices) {
            if (PRIMES_SET.contains(nums[i][i])) {
                result = maxOf(result, nums[i][i])
            }
            if (PRIMES_SET.contains(nums[i][nums.size - 1 - i])) {
                result = maxOf(result, nums[i][nums.size - 1 - i])
            }
        }
        return result
    }
}
