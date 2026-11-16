package maximumaveragepassratio

// Time:  O(n + mlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maxAverageRatio(classes: Array<IntArray>, extraStudents: Int): Double {
        fun profit(a: Double, b: Double): Double {
            return (a + 1) / (b + 1) - a / b
        }

        val comparator = compareByDescending<Triple<Double, Int, Int>> { it.first }
            .thenByDescending { it.second }
            .thenByDescending { it.third }
        val maxHeap = PriorityQueue<Triple<Double, Int, Int>>(comparator)
        for (c in classes) {
            maxHeap.offer(Triple(profit(c[0].toDouble(), c[1].toDouble()), c[0], c[1]))
        }
        var remaining = extraStudents
        while (remaining > 0) {
            val top = maxHeap.poll()
            val a = top.second + 1
            val b = top.third + 1
            maxHeap.offer(Triple(profit(a.toDouble(), b.toDouble()), a, b))
            --remaining
        }
        var total = 0.0
        for (entry in maxHeap) {
            total += (entry.second.toFloat() / entry.third).toDouble()
        }
        return total / classes.size
    }
}
