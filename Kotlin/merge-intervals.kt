package mergeintervals
// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        val result = mutableListOf<IntArray>()
        for (interval in intervals) {
            if (result.isEmpty() || interval[0] > result.last()[1]) {
                result.add(interval)
            } else {
                result.last()[1] = maxOf(result.last()[1], interval[1])
            }
        }
        return result.toTypedArray()
    }
}
