package meetingroomsii
// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeMap
import kotlin.math.max

class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val lookup = TreeMap<Int, Int>()
        for (i in intervals) {
            lookup[i[0]] = lookup.getOrDefault(i[0], 0) + 1
            lookup[i[1]] = lookup.getOrDefault(i[1], 0) - 1
        }
        var result = 0
        var curr = 0
        for (num in lookup.values) {
            curr += num
            result = max(result, curr)
        }
        return result
    }
}
