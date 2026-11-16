package maximumtotalsumwiththresholdconstraints

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSum(nums: IntArray, threshold: IntArray): Long {
        val groups = Array(nums.size) { mutableListOf<Int>() }
        for (i in threshold.indices) {
            groups[threshold[i] - 1].add(i)
        }
        val sortedIdxs = ArrayList<Int>(nums.size)
        for (group in groups) {
            sortedIdxs.addAll(group)
        }
        var result = 0L
        for (i in sortedIdxs.indices) {
            if (i + 1 < threshold[sortedIdxs[i]]) {
                break
            }
            result += nums[sortedIdxs[i]]
        }
        return result
    }
}
