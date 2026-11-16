package countsmallerelementswithoppositeparity

// Time:  O(nlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(index: Int, value: Int) {
        var i = index + 1
        while (i < bit.size) {
            bit[i] += value
            i += lowerBit(i)
        }
    }

    fun query(index: Int): Int {
        var i = index + 1
        var total = 0
        while (i > 0) {
            total += bit[i]
            i -= lowerBit(i)
        }
        return total
    }

    private fun lowerBit(i: Int): Int {
        return i and -i
    }
}

class Solution {
    fun countSmallerOppositeParity(nums: IntArray): IntArray {
        val sortedNums = nums.distinct().sorted()
        val valueToIndex = HashMap<Int, Int>()
        for (i in sortedNums.indices) {
            valueToIndex[sortedNums[i]] = i
        }
        val bits = Array(2) { BIT(valueToIndex.size) }
        val result = IntArray(nums.size)
        for (i in nums.lastIndex downTo 0) {
            val index = valueToIndex.getValue(nums[i])
            result[i] = bits[1 xor (nums[i] % 2)].query(index - 1)
            bits[nums[i] % 2].add(index, 1)
        }
        return result
    }
}
