package employeefreetime
// Time:  O(m * logn), m is the number of schedule, n is the number of employees, m >= n
// Space: O(n)

import java.util.PriorityQueue

data class Interval(var start: Int = 0, var end: Int = 0)

class Solution {
    fun employeeFreeTime(schedule: List<List<Interval>>): List<Interval> {
        val result = mutableListOf<Interval>()
        val minHeap = PriorityQueue<Triple<Int, Int, Int>>(
            compareBy({ it.first }, { it.second }, { it.third })
        )
        for (i in schedule.indices) {
            minHeap.offer(Triple(schedule[i][0].start, i, 0))
        }
        var lastEnd = -1
        while (minHeap.isNotEmpty()) {
            val (t, employee, index) = minHeap.poll()
            if (0 <= lastEnd && lastEnd < t) {
                result.add(Interval(lastEnd, t))
            }
            lastEnd = maxOf(lastEnd, schedule[employee][index].end)
            if (index + 1 < schedule[employee].size) {
                minHeap.offer(Triple(schedule[employee][index + 1].start, employee, index + 1))
            }
        }
        return result
    }
}
