package minimumintervaltoincludeeachquery
// Time:  O(nlogn + klogk + klogn)
// space: O(n + k)

import java.util.PriorityQueue

class Solution {
    fun minInterval(intervals: Array<IntArray>, queries: IntArray): IntArray {
        intervals.sortWith(compareBy({ it[0] }, { it[1] }))
        val sortedQueries = queries.mapIndexed { index, query -> Pair(query, index) }
            .sortedWith(compareBy({ it.first }, { it.second }))
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        var i = 0
        val result = IntArray(queries.size) { -1 }
        for ((q, idx) in sortedQueries) {
            while (i != intervals.size && intervals[i][0] <= q) {
                minHeap.add(Pair(intervals[i][1] - intervals[i][0] + 1, i))
                ++i
            }
            while (minHeap.isNotEmpty() && intervals[minHeap.peek().second][1] < q) {
                minHeap.poll()
            }
            result[idx] = if (minHeap.isNotEmpty()) minHeap.peek().first else -1
        }
        return result
    }
}
