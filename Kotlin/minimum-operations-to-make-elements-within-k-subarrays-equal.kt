package minimumoperationstomakeelementswithinksubarraysequal

// Time:  O(nlogx + k * n)
// Space: O(n)

// two bsts, dp
class Solution {
    fun minOperations(nums: IntArray, x: Int, k: Int): Long {
        val n = nums.size
        val sw = Slidingsw()
        val cost = LongArray(n + 1) { Long.MAX_VALUE }
        for (i in 0 until n) {
            if (i - x >= 0) {
                sw.remove(nums[i - x])
            }
            sw.add(nums[i])
            if (i >= x - 1) {
                val median = sw.median()
                cost[i + 1] = (median.toLong() * sw.leftSize - sw.total1) +
                    (sw.total2 - median.toLong() * sw.rightSize)
            }
        }
        var dp = LongArray(n + 1)
        repeat(k) { round ->
            val newDp = LongArray(n + 1) { Long.MAX_VALUE }
            var j = (round + 1) * x
            while (j <= n) {
                if (dp[j - x] != Long.MAX_VALUE) {
                    newDp[j] = minOf(newDp[j - 1], dp[j - x] + cost[j])
                }
                ++j
            }
            dp = newDp
        }
        return dp[n]
    }

    private class Slidingsw {
        private val left = java.util.TreeMap<Int, Int>()
        private val right = java.util.TreeMap<Int, Int>()
        var leftSize = 0
            private set
        var rightSize = 0
            private set
        var total1 = 0L
        var total2 = 0L

        fun add(value: Int) {
            if (left.isEmpty() || value <= left.lastKey()) {
                left.merge(value, 1, Int::plus)
                ++leftSize
                total1 += value
            } else {
                right.merge(value, 1, Int::plus)
                ++rightSize
                total2 += value
            }
            rebalance()
        }

        fun remove(value: Int) {
            if (value <= left.lastKey()) {
                decrement(left, value)
                --leftSize
                total1 -= value
            } else {
                decrement(right, value)
                --rightSize
                total2 -= value
            }
            rebalance()
        }

        fun median(): Int = left.lastKey()

        private fun rebalance() {
            if (leftSize < rightSize) {
                val x = right.firstKey()
                decrement(right, x)
                --rightSize
                total2 -= x
                left.merge(x, 1, Int::plus)
                ++leftSize
                total1 += x
            } else if (leftSize > rightSize + 1) {
                val x = left.lastKey()
                decrement(left, x)
                --leftSize
                total1 -= x
                right.merge(x, 1, Int::plus)
                ++rightSize
                total2 += x
            }
        }

        private fun decrement(map: java.util.TreeMap<Int, Int>, value: Int) {
            val c = map.getValue(value)
            if (c == 1) {
                map.remove(value)
            } else {
                map[value] = c - 1
            }
        }
    }
}
