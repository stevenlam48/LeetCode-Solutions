package kthnearestobstaclequeries
// Time:  O(qlogk)
// Space: O(k)

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun resultsArray(queries: Array<IntArray>, k: Int): IntArray {
        val result = mutableListOf<Int>()
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for (q in queries) {
            maxHeap.add(abs(q[0]) + abs(q[1]))
            if (maxHeap.size == k + 1) {
                maxHeap.remove()
            }
            result.add(if (maxHeap.size == k) maxHeap.peek() else -1)
        }
        return result.toIntArray()
    }
}
