package divideintervalsintominimumnumberofgroups

// Time:  O(nlogn)
// Space: O(n)

// sort, line sweep
class Solution {
    fun minGroups(intervals: Array<IntArray>): Int {
        val events = java.util.TreeMap<Int, Int>()
        for (i in intervals) {
            events[i[0]] = (events[i[0]] ?: 0) + 1
            events[i[1] + 1] = (events[i[1] + 1] ?: 0) - 1
        }
        var result = 0
        var curr = 0
        for (d in events.values) {
            curr += d
            result = maxOf(result, curr)
        }
        return result
    }
}
