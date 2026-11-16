package avoidfloodinthecity

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun avoidFlood(rains: IntArray): IntArray {
        val lookup = HashMap<Int, MutableList<Int>>()
        for (i in rains.size - 1 downTo 0) {
            lookup.getOrPut(rains[i]) { mutableListOf() }.add(i)
        }
        val result = mutableListOf<Int>()
        val minHeap = PriorityQueue<Int>()
        for (i in rains.indices) {
            if (rains[i] != 0) {
                val indices = lookup[rains[i]]!!
                if (indices.size >= 2) {
                    indices.removeAt(indices.size - 1)
                    minHeap.add(indices.last())
                }
                result.add(-1)
            } else if (minHeap.isNotEmpty()) {
                val j = minHeap.poll()
                if (j < i) {
                    return IntArray(0)
                }
                result.add(rains[j])
            } else {
                result.add(1)
            }
        }
        return if (minHeap.isEmpty()) result.toIntArray() else IntArray(0)
    }
}
