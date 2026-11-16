package findmedianfromdatastream

import java.util.PriorityQueue

// Time:  O(nlogn) for total n addNums, O(logn) per addNum, O(1) per findMedian.
// Space: O(n), total space

class MedianFinder {
    private val minHeap = PriorityQueue<Int>()
    private val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

    fun addNum(num: Int) {
        if (maxHeap.isEmpty() || num > maxHeap.peek()) {
            minHeap.add(num)
            if (minHeap.size > maxHeap.size + 1) {
                maxHeap.add(minHeap.poll())
            }
        } else {
            maxHeap.add(num)
            if (maxHeap.size > minHeap.size) {
                minHeap.add(maxHeap.poll())
            }
        }
    }

    fun findMedian(): Double {
        return if (minHeap.size == maxHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            minHeap.peek().toDouble()
        }
    }
}
