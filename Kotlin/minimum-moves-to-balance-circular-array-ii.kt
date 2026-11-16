package minimummovestobalancecirculararrayii

import java.util.PriorityQueue

// Time:  O(n^2 * logn)
// Space: O(n)

class Solution {
    fun minMoves(balance: IntArray): Long {
        var total = 0L
        for (x in balance) {
            total += x
        }
        if (total < 0) {
            return -1
        }

        val cost = { i: Int ->
            var result = 0L
            var prefix = 0L
            val maxHeap = PriorityQueue<Long>(compareByDescending { it })
            for (j in balance.indices) {
                prefix += balance[(i + j) % balance.size]
                val c = maxOf(0L, minOf(total, prefix))
                result += Math.abs(prefix - c)
                maxHeap.add(c)
                if (maxHeap.peek() > c) {
                    result += maxHeap.peek() - c
                    maxHeap.poll()
                    maxHeap.add(c)
                }
            }
            result
        }

        var result = Long.MAX_VALUE
        for (i in balance.indices) {
            result = minOf(result, cost(i))
        }
        return result
    }
}
