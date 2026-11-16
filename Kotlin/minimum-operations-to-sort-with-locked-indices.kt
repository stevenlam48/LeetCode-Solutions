package minimumoperationstosortwithlockedindices

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minOperations(nums: IntArray, locked: IntArray, k: Int): Int {
        var cnt = 0
        var inv = 0
        var mn = nums.size + 1
        val bit = BIT(nums.size)
        for (i in nums.indices.reversed()) {
            if (mn < i + 2 || minOf(mn, nums[i]) < i + 1) {
                cnt += locked[i]
            }
            mn = minOf(mn, nums[i])
            inv += bit.query(nums[i] - 1)
            bit.add(nums[i], 1)
        }
        return if (cnt <= k) cnt + inv else -1
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i: Int, value: Int) {
            var index = i + 1
            while (index < bit.size) {
                bit[index] += value
                index += lowerBit(index)
            }
        }

        fun query(i: Int): Int {
            var index = i + 1
            var total = 0
            while (index > 0) {
                total += bit[index]
                index -= lowerBit(index)
            }
            return total
        }

        private fun lowerBit(i: Int): Int = i and -i
    }
}
