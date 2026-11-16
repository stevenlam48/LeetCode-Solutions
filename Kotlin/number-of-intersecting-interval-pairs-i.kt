package numberofintersectingintervalpairsi
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun countIntersectingIntervals(intervals: Array<IntArray>): Int {
        val events = ArrayList<Pair<Int, Int>>(intervals.size * 2)
        for (x in intervals) {
            events.add(Pair(x[0], 1))
            events.add(Pair(x[1] + 1, -1))
        }
        events.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        var result = 0
        var cnt = 0
        for ((_, c) in events) {
            if (c == 1) {
                result += cnt
            }
            cnt += c
        }
        return result
    }
}
