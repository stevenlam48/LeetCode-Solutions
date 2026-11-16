package divisiblegame

// Time:  precompute: O(r)
//        runtime:    O(nlogx + f) = O(nlogx), f = sum of distinct prime factors over all nums (<= 7n)
// Space: O(r + n)

// number theory, kadane's algorithm, prefix sum
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

private const val MAX_NUMS = 1_000_000
private val SPF = linearSieveOfEratosthenes(MAX_NUMS)

class Solution {
    fun divisibleGame(nums: IntArray): Int {
        val MOD = 1_000_000_007

        val prefix = IntArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        val lookup = HashMap<Int, MutableList<Int>>()
        for (i in nums.indices) {
            var x = nums[i]
            while (x != 1) {
                val p = SPF[x]
                lookup.getOrPut(p) { mutableListOf() }.add(i)
                while (x % p == 0) {
                    x /= p
                }
            }
        }
        var bestDiff = -nums.min()
        var bestK = 2
        for ((p, idxs) in lookup) {
            var total = 0
            var j = -1
            for (i in idxs) {
                total = maxOf(total - (prefix[(i - 1) + 1] - prefix[j + 1]), 0) + nums[i]
                if (total > bestDiff) {
                    bestDiff = total
                    bestK = p
                } else if (total == bestDiff) {
                    bestK = minOf(bestK, p)
                }
                j = i
            }
        }
        return ((bestDiff.toLong() * bestK % MOD + MOD) % MOD).toInt()
    }
}
