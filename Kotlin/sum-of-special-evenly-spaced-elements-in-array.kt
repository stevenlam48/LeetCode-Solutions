package sumofspecialevenlyspacedelementsinarray

// Time:  O(n * sqrt(n))
// Space: O(n * sqrt(n))

import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    fun solve(nums: IntArray, queries: Array<IntArray>): IntArray {
        val mod = 1_000_000_007
        val size = floor(sqrt(queries.size.toDouble())).toInt() + 1
        val prefix = Array(size) { arrayOfNulls<IntArray>(size) }
        val result = mutableListOf<Int>()
        for (query in queries) {
            val x = query[0]
            val y = query[1]
            if (y.toLong() * y > queries.size) {
                var total = 0
                var i = x
                while (i < nums.size) {
                    total = (total + nums[i]) % mod
                    i += y
                }
                result.add(total)
            } else {
                val begin = x % y
                if (prefix[begin][y] == null) {
                    val sums = mutableListOf(0)
                    var i = begin
                    while (i < nums.size) {
                        sums.add((sums.last() + nums[i]) % mod)
                        i += y
                    }
                    prefix[begin][y] = sums.toIntArray()
                }
                val sums = prefix[begin][y]!!
                result.add((sums.last() - sums[x / y] + mod) % mod)
            }
        }
        return result.toIntArray()
    }
}
