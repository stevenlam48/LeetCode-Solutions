package finalarraystateafterkmultiplicationoperationsi

// Time:  O(n + (n + logr) + nlog(logr) + nlogn) = O(nlogn), assumed log(x) takes O(1) time
// Space: O(n)

class Solution {
    fun getFinalState(nums: IntArray, k: Int, multiplier: Int): IntArray {
        val EPS = 1e-15
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
        for (idx in vals.indices) {
            val (x, i) = vals[idx]
            val c = count(x, right)
            if (c <= 0) {
                break
            }
            nums[i] = (nums[i] * Math.pow(multiplier.toDouble(), c.toDouble())).toInt()
        }
        vals.clear()
        for (i in nums.indices) {
            vals.add(Pair(nums[i].toDouble(), i))
        }
        vals.sortWith(compareBy({ it.first }, { it.second }))
        val q = kk / nums.size
        val r = kk % nums.size
        val m = Math.pow(multiplier.toDouble(), q.toDouble()).toInt()
        val result = IntArray(nums.size)
        for (idx in vals.indices) {
            val (x, i) = vals[idx]
            result[i] = (x * m * (if (idx < r) multiplier else 1)).toInt()
        }
        return result
    }
}
