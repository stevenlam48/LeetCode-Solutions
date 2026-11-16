package meetingroomsiii
// Time:  O(mlogm + n + mlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        meetings.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] })
        val minHeap = PriorityQueue<Pair<Long, Int>>(compareBy({ it.first }, { it.second }))
        for (i in 0 until n) {
            minHeap.add(meetings[0][0].toLong() to i)
        }
        val result = IntArray(n)
        for (m in meetings) {
            val s = m[0]
            val e = m[1]
            while (minHeap.isNotEmpty() && minHeap.peek().first < s) {
                val room = minHeap.poll()
                minHeap.add(s.toLong() to room.second)
            }
            val room = minHeap.poll()
            minHeap.add(room.first + (e - s) to room.second)
            ++result[room.second]
        }
        var index = 0
        for (i in 1 until result.size) {
            if (result[i] > result[index]) {
                index = i
            }
        }
        return index
    }
}
