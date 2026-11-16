package xorafterrangemultiplicationqueriesii

// Time:  O(qlogm + (q + n) * sqrt(n))
// Space: O(n * sqrt(n))

import kotlin.math.sqrt

class Solution {
    fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
        val mod = 1_000_000_007L

        fun powMod(initialA: Long, initialB: Long, modulus: Long): Long {
            var a = initialA % modulus
            var b = initialB
            var result = 1L
            while (b != 0L) {
                if (b and 1L != 0L) result = result * a % modulus
                a = a * a % modulus
                b = b shr 1
            }
            return result
        }

        fun inverse(x: Int, p: Long): Long = powMod(x.toLong(), p - 2, p)

        val blockSize = sqrt(nums.size.toDouble()).toInt() + 1
        val diffs = HashMap<Int, LongArray>()
        for (query in queries) {
            val l = query[0]
            var r = query[1]
            val k = query[2]
            val v = query[3]
            if (k <= blockSize) {
                val diff = diffs.getOrPut(k) { LongArray(nums.size) { 1L } }
                diff[l] = diff[l] * v % mod
                r += k - (r - l) % k
                if (r < nums.size) diff[r] = diff[r] * inverse(v, mod) % mod
            } else {
                var i = l
                while (i <= r) {
                    nums[i] = (nums[i].toLong() * v % mod).toInt()
                    i += k
                }
            }
        }
        for ((k, diff) in diffs) {
            for (i in diff.indices) {
                if (i - k >= 0) diff[i] = diff[i] * diff[i - k] % mod
                nums[i] = (nums[i] * diff[i] % mod).toInt()
            }
        }
        var result = 0
        for (value in nums) result = result xor value
        return result
    }
}
