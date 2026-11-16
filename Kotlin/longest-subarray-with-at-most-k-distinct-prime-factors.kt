package longestsubarraywithatmostkdistinctprimefactors
// Time:  ctor:    O(r)
//        runtime: O(nlogr)
// Space: O(r)

private fun linearSieveOfEratosthenes(n: Int): IntArray {
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
    return spf
}

private const val MAX_NUMS = 100_000
private val SPF = linearSieveOfEratosthenes(MAX_NUMS)

class Solution {
    fun longestSubarray(nums: IntArray, k: Int): Int {
        fun primeFactors(value: Int): Map<Int, Int> {
            var x = value
            val counts = HashMap<Int, Int>()
            while (x != 1) {
                counts[SPF[x]] = counts.getOrDefault(SPF[x], 0) + 1
                x /= SPF[x]
            }
            return counts
        }

        val counts = HashMap<Int, Int>()
        var left = 0
        for (x in nums) {
            for ((prime, count) in primeFactors(x)) {
                counts[prime] = counts.getOrDefault(prime, 0) + count
            }
            if (counts.size <= k) {
                continue
            }
            for ((prime, count) in primeFactors(nums[left])) {
                val remaining = counts.getValue(prime) - count
                if (remaining == 0) {
                    counts.remove(prime)
                } else {
                    counts[prime] = remaining
                }
            }
            ++left
        }
        return nums.size - left
    }
}
