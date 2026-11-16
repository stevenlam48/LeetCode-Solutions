package nonoverlappingintervals

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy { it[1] })
        var result = 0
        var right = Int.MIN_VALUE
        for (x in intervals) {
            if (x[0] < right) {
                ++result
            } else {
                right = x[1]
            }
        }
        return result
    }
}
