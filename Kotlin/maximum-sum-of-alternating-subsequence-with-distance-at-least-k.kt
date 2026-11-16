package maximumsumofalternatingsubsequencewithdistanceatleastk
// Time:  O(nlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = LongArray(n + 1)

    fun add(i: Int, value: Long) {
        var index = i + 1
        while (index < bit.size) {
            bit[index] = maxOf(bit[index], value)
            index += lowerBit(index)
        }
    }

    fun query(i: Int): Long {
        var index = i + 1
        var total = 0L
        while (index > 0) {
            total = maxOf(total, bit[index])
            index -= lowerBit(index)
        }
        return total
    }

    private fun lowerBit(i: Int): Int = i and -i
}

class Solution {
    fun maxAlternatingSum(nums: IntArray, k: Int): Long {
        val sortedNums = nums.copyOf()
        sortedNums.sort()
        val values = sortedNums.distinct()
        val valToIdx = HashMap<Int, Int>()
        for (i in values.indices) {
            valToIdx[values[i]] = i
        }
        val bit = Array(2) { BIT(values.size) }
        val dp = Array(2) { LongArray(nums.size) }
        for (i in nums.indices) {
            if (i - k >= 0) {
                val previousIdx = valToIdx[nums[i - k]]!!
                bit[0].add(previousIdx, dp[0][i - k])
                bit[1].add((values.size - 1) - previousIdx, dp[1][i - k])
            }
            val idx = valToIdx[nums[i]]!!
            dp[1][i] = bit[0].query(idx - 1) + nums[i]
            dp[0][i] = bit[1].query(((values.size - 1) - idx) - 1) + nums[i]
        }
        return maxOf(dp[0].max(), dp[1].max())
    }
}
