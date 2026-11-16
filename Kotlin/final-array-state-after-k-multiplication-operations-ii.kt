package finalarraystateafterkmultiplicationoperationsii

// Time:  O(n + (n + logr) + nlog(logr) + nlogn) = O(nlogn), assumed log(x) takes O(1) time
// Space: O(n)

class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val EPS = 1e-15
        val MOD = 1_000_000_007
        fun powmod(a0: Int, b0: Int): Int {
            var a = a0 % MOD
            var b = b0
            var result = 1L
            while (b != 0) {
                if (b and 1 != 0) {
                    result = result * a % MOD
                }
                a = (a.toLong() * a % MOD).toInt()
                b = b shr 1
            }
            return result.toInt()
        }
        fun count(x: Double, target: Int): Int = (target - x + EPS).toInt()

        if (multiplier == 1) {
            return nums
        }
        var kk = k
        val vals = mutableListOf<Pair<Double, Int>>()
        for (i in nums.indices) {
            vals.add(Pair(Math.log(nums[i].toDouble()) / Math.log(multiplier.toDouble()), i))
        }
        vals.sortWith(compareBy({ it.first }, { it.second }))
        var right = 1
        var left = 0
        while (right <= vals.last().first.toInt() + 1) {
            while (left < vals.size && count(vals[left].first, right) >= 1) {
                ++left
            }
            if (kk - left < 0) {
                --right
                break
            }
            kk -= left
            ++right
        }
        if (right == vals.last().first.toInt() + 2) {
            --right
        }
        val nums2 = LongArray(nums.size) { nums[it].toLong() }
        for (idx in vals.indices) {
            val (x, i) = vals[idx]
            val c = count(x, right)
            if (c <= 0) {
                break
            }
            nums2[i] = (nums2[i] * Math.pow(multiplier.toDouble(), c.toDouble())).toLong()
        }
        val vals2 = mutableListOf<Pair<Long, Int>>()
        for (i in nums2.indices) {
            vals2.add(Pair(nums2[i], i))
        }
        vals2.sortWith(compareBy({ it.first }, { it.second }))
        val q = kk / nums.size
        val r = kk % nums.size
        val m = powmod(multiplier, q)
        val result = IntArray(nums.size)
        for (idx in vals2.indices) {
            val (x, i) = vals2[idx]
            result[i] = (((x % MOD) * m) % MOD * (if (idx < r) multiplier else 1) % MOD).toInt()
        }
        return result
    }
}
