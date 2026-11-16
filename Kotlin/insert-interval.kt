package insertinterval
// Time:  O(n)
// Space: O(1)

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        var i = 0
        val result = mutableListOf<IntArray>()
        var merged = newInterval
        while (i < intervals.size && merged[0] > intervals[i][1]) {
            result.add(intervals[i++])
        }
        while (i < intervals.size && merged[1] >= intervals[i][0]) {
            merged = intArrayOf(
                minOf(merged[0], intervals[i][0]),
                maxOf(merged[1], intervals[i][1])
            )
            ++i
        }
        result.add(merged)
        while (i < intervals.size) {
            result.add(intervals[i++])
        }
        return result.toTypedArray()
    }
}
