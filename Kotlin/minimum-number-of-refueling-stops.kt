package minimumnumberofrefuelingstops

// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun minRefuelStops(target: Int, startFuel: Int, stations: Array<IntArray>): Int {
        var fuel = startFuel
        val maxHeap = PriorityQueue<Int>(compareByDescending { value: Int -> value })
        var result = 0
        var prev = 0
        for (i in 0..stations.size) {
            val station = if (i < stations.size) stations[i] else intArrayOf(target, Int.MIN_VALUE)
            fuel -= station[0] - prev
            while (maxHeap.isNotEmpty() && fuel < 0) {
                fuel += maxHeap.poll()
                ++result
            }
            if (fuel < 0) {
                return -1
            }
            maxHeap.add(station[1])
            prev = station[0]
        }
        return result
    }
}
