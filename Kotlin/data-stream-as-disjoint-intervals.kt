package datastreamasdisjointintervals

import java.util.TreeMap

// Time:  addNum: O(logn), getIntervals: O(n), n is the number of disjoint intervals.
// Space: O(n)

class Interval(var start: Int = 0, var end: Int = 0)

class SummaryRanges {
    private val intervals = TreeMap<Int, Int>()

    fun addNum(`val`: Int) {
        var start = `val`
        var end = `val`
        val prevKey = intervals.floorKey(`val`)
        var it: Int? = if (prevKey != null && intervals[prevKey]!! + 1 >= `val`) {
            prevKey
        } else {
            intervals.higherKey(`val`)
        }
        while (it != null && end + 1 >= it) {
            start = Math.min(start, it)
            end = Math.max(end, intervals[it]!!)
            intervals.remove(it)
            it = intervals.higherKey(it)
        }
        intervals[start] = end
    }

    fun getIntervals(): List<Interval> {
        val result = ArrayList<Interval>()
        for ((start, end) in intervals) {
            result.add(Interval(start, end))
        }
        return result
    }
}
