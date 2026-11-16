package maximumnumberofeventsthatcanbeattended

import java.util.PriorityQueue

// Time:  O(r + nlogn), r is the max end day of events
// Space: O(n)

class Solution {
    fun maxEvents(events: Array<IntArray>): Int {
        events.sortWith(
            compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] }
        )
        val maxDay = events.maxOf { it[1] }
        val minHeap = PriorityQueue<Int>()
        var result = 0
        var idx = events.size - 1
        for (d in 1..maxDay) {
            while (idx >= 0 && events[idx][0] == d) {
                minHeap.add(events[idx][1])
                --idx
            }
            while (minHeap.isNotEmpty() && minHeap.peek() == d - 1) {
                minHeap.poll()
            }
            if (minHeap.isEmpty()) {
                continue
            }
            minHeap.poll()
            ++result
        }
        return result
    }
}
