package findserversthathandledmostnumberofrequests

// Time:  O(nlogk)
// Space: O(k)

class Solution {
    fun busiestServers(k: Int, arrival: IntArray, load: IntArray): List<Int> {
        val minHeapOfEndtimes = java.util.PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }))
        var minHeapOfNodesAfterCurr = java.util.PriorityQueue<Int>()
        var minHeapOfNodesBeforeCurr = java.util.PriorityQueue<Int>()
        for (i in 0 until k) {
            minHeapOfNodesBeforeCurr.add(i)
        }
        val count = IntArray(k)
        for (i in arrival.indices) {
            if (i % k == 0) {
                minHeapOfNodesAfterCurr = minHeapOfNodesBeforeCurr
                minHeapOfNodesBeforeCurr = java.util.PriorityQueue<Int>()
            }
            while (minHeapOfEndtimes.isNotEmpty() && minHeapOfEndtimes.peek()[0] <= arrival[i]) {
                val free = minHeapOfEndtimes.poll()[1]
                if (free < i % k) {
                    minHeapOfNodesBeforeCurr.add(free)
                } else {
                    minHeapOfNodesAfterCurr.add(free)
                }
            }
            val minHeapOfCandidates = if (minHeapOfNodesAfterCurr.isNotEmpty()) minHeapOfNodesAfterCurr else minHeapOfNodesBeforeCurr
            if (minHeapOfCandidates.isEmpty()) {
                continue
            }
            val node = minHeapOfCandidates.poll()
            ++count[node]
            minHeapOfEndtimes.add(intArrayOf(arrival[i] + load[i], node))
        }
        val maxCount = count.maxOrNull()!!
        val result = mutableListOf<Int>()
        for (i in 0 until k) {
            if (count[i] == maxCount) {
                result.add(i)
            }
        }
        return result
    }
}
