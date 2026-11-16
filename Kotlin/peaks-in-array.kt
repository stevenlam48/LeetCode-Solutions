package peaksinarray

// Time:  O(n + qlogn)
// Space: O(n)

class Solution {
    fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): IntArray {
        fun check(i: Int): Boolean {
            return nums[i - 1] < nums[i] && nums[i] > nums[i + 1]
        }

        val arr = IntArray(nums.size)
        for (i in nums.indices) {
            if (1 <= i && i <= nums.size - 2 && check(i)) {
                arr[i] = 1
            }
        }
        val bit = BIT(arr)

        fun update(x: Int, d: Int) {
            var i = maxOf(x - 1, 1)
            val hi = minOf(x + 1, nums.size - 2)
            while (i <= hi) {
                if (check(i)) {
                    bit.add(i, d)
                }
                ++i
            }
        }

        val result = mutableListOf<Int>()
        for (q in queries) {
            val t = q[0]
            val x = q[1]
            val y = q[2]
            if (t == 1) {
                result.add(if (y - 1 >= x + 1) bit.query(y - 1) - bit.query(x) else 0)
                continue
            }
            update(x, -1)
            nums[x] = y
            update(x, +1)
        }
        return result.toIntArray()
    }

    private class BIT(nums: IntArray) {
        private val bit = IntArray(nums.size + 1)

        init {
            for (i in 1 until bit.size) {
                bit[i] = nums[i - 1] + bit[i - 1]
            }
            for (i in bit.size - 1 downTo 1) {
                val lastI = i - lowerBit(i)
                bit[i] -= bit[lastI]
            }
        }

        fun add(i: Int, value: Int) {
            var idx = i + 1
            while (idx < bit.size) {
                bit[idx] += value
                idx += lowerBit(idx)
            }
        }

        fun query(i: Int): Int {
            var idx = i + 1
            var total = 0
            while (idx > 0) {
                total += bit[idx]
                idx -= lowerBit(idx)
            }
            return total
        }

        private fun lowerBit(i: Int): Int {
            return i and -i
        }
    }
}
