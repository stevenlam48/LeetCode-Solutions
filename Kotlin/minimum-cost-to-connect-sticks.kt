package minimumcosttoconnectsticks
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun connectSticks(sticks: IntArray): Int {
        val minHeap = PriorityQueue<Int>(compareBy { it })
        minHeap.addAll(sticks.toList())
        var result = 0
        while (minHeap.size > 1) {
            val x = minHeap.poll()
            val y = minHeap.poll()
            result += x + y
            minHeap.add(x + y)
        }
        return result
    }
}
