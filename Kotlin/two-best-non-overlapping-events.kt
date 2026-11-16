package twobestnonoverlappingevents
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        var result = 0
        var best = 0
        for (event in events) {
            minHeap.add(event[1] to event[2])
            while (minHeap.isNotEmpty() && minHeap.peek().first < event[0]) {
                best = maxOf(best, minHeap.remove().second)
            }
            result = maxOf(result, best + event[2])
        }
        return result
    }
}
