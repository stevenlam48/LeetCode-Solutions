package minimumabsolutedifferencequeries

// Time:  O(r * (n + q)), r is the max of nums
// Space: O(r * n)

class Solution {
    fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
        val maxVal = nums.max()
        val prefix = Array(nums.size + 1) { IntArray(maxVal + 1) }
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i].copyOf()
            ++prefix[i + 1][nums[i]]
        }
        val result = IntArray(queries.size)
        for ((qi, query) in queries.withIndex()) {
            var minDiff = Int.MAX_VALUE
            var prev = -1
            for (num in 0..maxVal) {
                if (!(prefix[query[0]][num] < prefix[query[1] + 1][num])) {
                    continue
                }
                if (prev != -1) {
                    minDiff = minOf(minDiff, num - prev)
                }
                prev = num
            }
            result[qi] = if (minDiff != Int.MAX_VALUE) minDiff else -1
        }
        return result
    }
}
