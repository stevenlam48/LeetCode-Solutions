package maximumsubarraysumoffixedlengthafteratmostkswaps

// Time:  O(nlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = LongArray(n + 1)

    fun add(i: Int, value: Long) {
        var index = i + 1
        while (index < bit.size) {
            bit[index] += value
            index += index and -index
        }
    }

    fun query(i: Int): Long {
        var index = i + 1
        var result = 0L
        while (index > 0) {
            result += bit[index]
            index -= index and -index
        }
        return result
    }

    fun kthElement(k: Int): Int {
        if (k <= 0) {
            return -1
        }
        var result = 0L
        var position = 0
        for (i in 31 - (bit.size - 1).countLeadingZeroBits() downTo 0) {
            val step = 1 shl i
            if (position + step < bit.size && result + bit[position + step] < k) {
                result += bit[position + step]
                position += step
            }
        }
        return position
    }
}

class Solution {
    fun maxSum(nums: IntArray, length: Int, k: Int): Long {
        val inside = 0
        val outside = 1
        val swaps = minOf(k, length, nums.size - length)
        if (swaps == 0) {
            var result = nums.take(length).sumOf { it.toLong() }
            var current = result
            for (i in length until nums.size) {
                current += nums[i] - nums[i - length]
                result = maxOf(result, current)
            }
            return result
        }
        val order = Array(nums.size) { it }
        order.sortBy { nums[it] }
        val rank = IntArray(nums.size)
        for (i in order.indices) {
            rank[order[i]] = i
        }
        val count = arrayOf(BIT(nums.size), BIT(nums.size))
        val total = arrayOf(BIT(nums.size), BIT(nums.size))

        fun update(i: Int, side: Int, difference: Int) {
            count[side].add(rank[i], difference.toLong())
            total[side].add(rank[i], difference.toLong() * nums[i])
        }

        fun topTotal(side: Int, i: Int): Long {
            val size = if (side == inside) length else nums.size - length
            return total[side].query(nums.size - 1) -
                total[side].query(count[side].kthElement(size - i))
        }

        for (i in 0 until length) {
            update(i, inside, 1)
        }
        for (i in length until nums.size) {
            update(i, outside, 1)
        }
        var result = total[inside].query(nums.size - 1)
        var current = 0
        for (i in 0 until length) {
            current += if (rank[i] >= nums.size - length) 1 else 0
        }
        for (left in 0..nums.size - length) {
            if (current >= length - swaps) {
                var topResult = 0L
                for (i in nums.indices) {
                    if (rank[i] >= nums.size - length) {
                        topResult += nums[i]
                    }
                }
                return topResult
            }
            result = maxOf(result, topTotal(inside, length - swaps) + topTotal(outside, swaps))
            val right = left + length
            if (right >= nums.size) {
                continue
            }
            update(left, inside, -1)
            update(left, outside, 1)
            update(right, outside, -1)
            update(right, inside, 1)
            current += (if (rank[right] >= nums.size - length) 1 else 0) -
                (if (rank[left] >= nums.size - length) 1 else 0)
        }
        return result
    }
}
