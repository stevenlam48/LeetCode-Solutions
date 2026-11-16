package minimuminversioncountinsubarraysoffixedlength

// Time:  O(nlogn)
// Space: O(n)

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

class Solution {
    fun minInversionCount(nums: IntArray, k: Int): Long {
        val vals = nums.sortedArray().distinct().toIntArray()
        val valToIdx = HashMap<Int, Int>()
        for (i in vals.indices) {
            valToIdx[vals[i]] = i
        }
        var result = Long.MAX_VALUE
        var count = 0L
        val bit = BIT(valToIdx.size)
        for (i in nums.indices) {
            val idx = valToIdx[nums[i]]!!
            bit.add(idx, 1)
            count += (bit.query(valToIdx.size - 1) - bit.query(idx)).toLong()
            if (i < k - 1) {
                continue
            }
            result = minOf(result, count)
            val removeIdx = valToIdx[nums[i - (k - 1)]]!!
            count -= bit.query(removeIdx - 1).toLong()
            bit.add(removeIdx, -1)
        }
        return result
    }
}
