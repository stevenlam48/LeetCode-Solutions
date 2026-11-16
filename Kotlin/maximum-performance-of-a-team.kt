package maximumperformanceofateam
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maxPerformance(n: Int, speed: IntArray, efficiency: IntArray, k: Int): Int {
        val mod = 1_000_000_007L
        var result = 0L
        var speedSum = 0L
        val engineers = mutableListOf<Pair<Int, Int>>()
        for (i in speed.indices) {
            engineers.add(efficiency[i] to speed[i])
        }
        engineers.sortWith(compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second })
        val minHeap = PriorityQueue<Int>(compareBy { it })
        for ((e, s) in engineers) {
            speedSum += s
            minHeap.add(s)
            if (minHeap.size > k) {
                speedSum -= minHeap.remove()
            }
            result = maxOf(result, speedSum * e)
        }
        return (result % mod).toInt()
    }
}
