package meetingscheduler
// Time:  O(n) ~ O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): IntArray {
        val minHeap = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }))
        for (slot in slots1) {
            if (slot[1] - slot[0] >= duration) {
                minHeap.add(slot)
            }
        }
        for (slot in slots2) {
            if (slot[1] - slot[0] >= duration) {
                minHeap.add(slot)
            }
        }
        while (minHeap.size > 1) {
            val left = minHeap.poll()
            val right = minHeap.poll()
            minHeap.add(right)
            if (left[1] - right[0] >= duration) {
                return intArrayOf(right[0], right[0] + duration)
            }
        }
        return intArrayOf()
    }
}
