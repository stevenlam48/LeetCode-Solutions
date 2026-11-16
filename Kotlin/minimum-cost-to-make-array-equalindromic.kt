package minimumcosttomakearrayequalindromic
// Time:  O(n + logr)
// Space: O(logr)

import kotlin.math.abs

class Solution {
    fun minimumCost(nums: IntArray): Long {
        fun nearestPalindromic(x: Int): Set<Long> {
            val n = x.toString()
            val l = n.length
            val result = HashSet<Long>()
            result.add(Math.pow(10.0, l.toDouble()).toLong() + 1)
            result.add(Math.pow(10.0, (l - 1).toDouble()).toLong() - 1)
            val prefix = n.substring(0, (l + 1) / 2).toLong()
            for (i in -1L..1L) {
                val p = (prefix + i).toString()
                val pp = p + p.reversed().drop(l % 2)
                result.add(pp.toLong())
            }
            return result
        }

        nums.sort()
        var median = nums[nums.size / 2]
        if (nums.size % 2 == 0) {
            median = (median + nums[nums.size / 2 - 1]) / 2
        }
        var result = Long.MAX_VALUE
        for (p in nearestPalindromic(median)) {
            result = minOf(result, nums.sumOf { x -> abs(x - p) })
        }
        return result
    }
}
