package minimizeconnectedgroupsbyinsertinginterval

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minConnectedGroups(intervals: Array<IntArray>, k: Int): Int {
        intervals.sortWith(compareBy({ it[0] }, { it[1] }))
        var result = 0
        val prefix = IntArray(intervals.size + 1)
        var left = 0
        var mx = Int.MIN_VALUE
        for (right in intervals.indices) {
            prefix[right + 1] = prefix[right] + if (mx < intervals[right][0]) 1 else 0
            mx = maxOf(mx, intervals[right][1])
            while (intervals[right][0] - intervals[left][1] > k) {
                ++left
            }
            result = maxOf(result, prefix[right + 1] - prefix[left + 1])
        }
        return prefix.last() - result
    }
}
