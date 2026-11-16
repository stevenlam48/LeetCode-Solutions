package countequalanddivisiblepairsinanarray

// Time:  O(nlogk + n * sqrt(k))
// Space: O(n + sqrt(k)), number of factors of k is at most sqrt(k)

// math, number theory
class Solution {
    fun countPairs(nums: IntArray, k: Int): Int {
        val idxs = HashMap<Int, MutableList<Int>>()
        for (i in nums.indices) {
            idxs.getOrPut(nums[i]) { mutableListOf() }.add(i)
        }
        var result = 0
        for (idx in idxs.values) {
            val gcds = HashMap<Int, Int>()
            for (i in idx) {
                val gcdI = gcd(i, k)
                for ((gcdJ, cnt) in gcds) {
                    if (gcdI.toLong() * gcdJ % k == 0L) {
                        result += cnt
                    }
                }
                gcds[gcdI] = (gcds[gcdI] ?: 0) + 1
            }
        }
        return result
    }

    private fun gcd(a0: Int, b0: Int): Int {
        var a = a0
        var b = b0
        while (b != 0) {
            val t = a % b
            a = b
            b = t
        }
        return a
    }
}
