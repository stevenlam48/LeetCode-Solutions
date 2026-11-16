package removecoveredintervals
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(Comparator { a, b ->
            if (a[0] != b[0]) a[0].compareTo(b[0]) else b[1].compareTo(a[1])
        })
        var result = 0
        var maxRight = 0
        for (interval in intervals) {
            if (interval[1] > maxRight) {
                ++result
            }
            maxRight = maxOf(maxRight, interval[1])
        }
        return result
    }
}
