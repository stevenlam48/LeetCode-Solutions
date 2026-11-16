package campusbikes

import java.util.PriorityQueue

// Time:  O((w * b) * log(w * b))
// Space: O(w * b)

class Solution {
    fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): IntArray {
        val distances = Array(workers.size) { mutableListOf<IntArray>() }
        for (i in workers.indices) {
            for (j in bikes.indices) {
                distances[i].add(intArrayOf(manhattan(workers[i], bikes[j]), i, j))
            }
            distances[i].sortWith(compareByDescending<IntArray> { it[0] }.thenByDescending { it[1] }.thenByDescending { it[2] })
        }

        val result = IntArray(workers.size)
        val lookup = HashSet<Int>()
        val minHeap = PriorityQueue<IntArray>(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })
        for (i in workers.indices) {
            minHeap.add(distances[i].removeAt(distances[i].size - 1))
        }
        while (lookup.size < workers.size) {
            val worker = minHeap.peek()[1]
            val bike = minHeap.peek()[2]
            minHeap.poll()
            if (!lookup.contains(bike)) {
                result[worker] = bike
                lookup.add(bike)
            } else {
                minHeap.add(distances[worker].removeAt(distances[worker].size - 1))
            }
        }
        return result
    }

    private fun manhattan(p1: IntArray, p2: IntArray): Int {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1])
    }
}
