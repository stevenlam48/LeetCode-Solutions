package minimumtimetobuildblocks

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minBuildTime(blocks: IntArray, split: Int): Int {
        val minHeap = PriorityQueue<Int>()
        for (b in blocks) {
            minHeap.add(b)
        }
        while (minHeap.size != 1) {
            minHeap.poll()
            val y = minHeap.peek()
            minHeap.poll()
            minHeap.add(y + split)
        }
        return minHeap.peek()
    }
}
