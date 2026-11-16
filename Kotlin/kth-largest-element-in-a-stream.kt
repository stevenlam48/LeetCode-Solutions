package kthlargestelementinastream

import java.util.PriorityQueue

// Time:  O(nlogk)
// Space: O(k)

class KthLargest(k: Int, nums: IntArray) {
    private val k_: Int = k
    private val minHeap = PriorityQueue<Int>()

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun add(`val`: Int): Int {
        minHeap.add(`val`)
        if (minHeap.size > k_) {
            minHeap.poll()
        }
        return minHeap.peek()
    }
}
