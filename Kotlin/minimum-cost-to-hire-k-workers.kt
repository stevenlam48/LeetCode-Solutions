package minimumcosttohirekworkers
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, K: Int): Double {
        val workers = Array(quality.size) { i -> (wage[i].toDouble() / quality[i]) to quality[i] }
        workers.sortWith(compareBy<Pair<Double, Int>> { it.first }.thenBy { it.second })
        var result = Double.MAX_VALUE
        var sum = 0.0
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        for ((ratio, q) in workers) {
            sum += q
            maxHeap.add(q)
            if (maxHeap.size > K) {
                sum -= maxHeap.poll()
            }
            if (maxHeap.size == K) {
                result = minOf(result, sum * ratio)
            }
        }
        return result
    }
}
