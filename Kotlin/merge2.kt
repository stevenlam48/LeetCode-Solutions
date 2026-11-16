package merge2

// Time Complexity: O(nlogn)
// Space Complexity: O(1)

class Interval(var start: Int = 0, var end: Int = 0)

class Solution {
    fun merge(intervals: MutableList<Interval>): List<Interval> {
        intervals.sortBy { it.start }
        val ans = mutableListOf<Interval>()
        val n = intervals.size
        var i = 0
        while (i < n) {
            ans.add(Interval(intervals[i].start, intervals[i].end))
            i++
            while (i < n && intervals[i].start <= ans.last().end) {
                ans.last().end = maxOf(ans.last().end, intervals[i].end)
                i++
            }
        }
        return ans
    }
}
