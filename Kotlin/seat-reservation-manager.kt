package seatreservationmanager

// Time:  ctor:      O(n)
//        reserve:   O(logn)
//        unreserve: O(logn)
// Space: O(n)

import java.util.PriorityQueue

class SeatManager(n: Int) {
    private val minHeap = PriorityQueue<Int>(n, naturalOrder())

    init {
        for (i in 1..n) {
            minHeap.add(i)
        }
    }

    fun reserve(): Int {
        return minHeap.remove()
    }

    fun unreserve(seatNumber: Int) {
        minHeap.add(seatNumber)
    }
}
