package highfive
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue
import java.util.TreeMap

class Solution {
    fun highFive(items: Array<IntArray>): Array<IntArray> {
        val minHeaps = TreeMap<Int, PriorityQueue<Int>>()
        for (item in items) {
            val minHeap = minHeaps.getOrPut(item[0]) { PriorityQueue(compareBy { it }) }
            minHeap.add(item[1])
            if (minHeap.size > 5) {
                minHeap.poll()
            }
        }

        val result = mutableListOf<IntArray>()
        for ((i, minHeap) in minHeaps) {
            var total = 0
            val count = minHeap.size
            while (minHeap.isNotEmpty()) {
                total += minHeap.poll()
            }
            result.add(intArrayOf(i, total / count))
        }
        return result.toTypedArray()
    }
}
