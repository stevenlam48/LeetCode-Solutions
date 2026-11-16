package laststoneweight

// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(stones.size, compareByDescending { it })
        for (stone in stones) {
            maxHeap.add(stone)
        }
        for (i in 0 until stones.size - 1) {
            val x = maxHeap.poll()
            val y = maxHeap.poll()
            maxHeap.add(abs(x - y))
        }
        return maxHeap.peek()
    }
}
