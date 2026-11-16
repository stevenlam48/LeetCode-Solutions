package splitarraybyprimeindices
// Time:  precompute: O(max_n), max_n = max(len(nums))
//        runtime:    O(n)
// Space: O(max_n)

private fun linearSieveOfEratosthenes(n: Long): LongArray {
    val spf = LongArray((n + 1).toInt()) { -1L }
    val primes = mutableListOf<Long>()
    for (i in 2L..n) {
        if (spf[i.toInt()] == -1L) {
            spf[i.toInt()] = i
            primes.add(i)
        }
        for (p in primes) {
            if (i * p > n || p > spf[i.toInt()]) {
                break
            }
            spf[(i * p).toInt()] = p
        }
    }
    return spf
}

private const val MAX_IDX = 100_000 - 1
private val SPF = linearSieveOfEratosthenes(MAX_IDX.toLong())

class Solution {
    fun splitArray(nums: IntArray): Long {
        var result = 0L
        for (i in nums.indices) {
            result += if (SPF[i] == i.toLong()) nums[i].toLong() else -nums[i].toLong()
        }
        return kotlin.math.abs(result)
    }
}
