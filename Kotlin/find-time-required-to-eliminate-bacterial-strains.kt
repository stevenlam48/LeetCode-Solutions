package findtimerequiredtoeliminatebacterialstrains

// Time:  O(nlogn)
// Space: O(n)

// heap, greedy
class Solution {
    fun minEliminationTime(timeReq: IntArray, splitTime: Int): Long {
        val minHeap = java.util.PriorityQueue<Long>()
        for (x in timeReq) {
            minHeap.add(x.toLong())
        }
        for (i in 0 until timeReq.size - 1) {
            val a = minHeap.poll()
            val b = minHeap.poll()
            minHeap.add(maxOf(a, b) + splitTime)
        }
        return minHeap.peek()
    }
}
