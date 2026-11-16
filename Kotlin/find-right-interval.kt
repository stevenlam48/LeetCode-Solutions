package findrightinterval

// Time:  O(nlogn)
// Space: O(n)

/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Interval(var start: Int = 0, var end: Int = 0)

class Solution {
    fun findRightInterval(intervals: Array<Interval>): IntArray {
        val lookup = java.util.TreeMap<Int, Int>()
        val result = mutableListOf<Int>()
        for (i in intervals.indices) {
            lookup[intervals[i].start] = i
        }
        for (interval in intervals) {
            val it = lookup.ceilingKey(interval.end)
            if (it == null) {
                result.add(-1)
            } else {
                result.add(lookup[it]!!)
            }
        }
        return result.toIntArray()
    }
}
