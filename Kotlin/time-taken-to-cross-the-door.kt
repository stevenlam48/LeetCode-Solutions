package timetakentocrossthedoor
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun timeTaken(arrival: IntArray, state: IntArray): IntArray {
        val unknown = -1
        val exiting = 1
        val result = IntArray(arrival.size)
        var current = Int.MIN_VALUE
        var direction = unknown
        val queues = Array(2) { ArrayDeque<Int>() }

        fun goUntil(t: Int) {
            while (current <= t && (queues[0].isNotEmpty() || queues[1].isNotEmpty())) {
                if (queues[direction].isEmpty()) {
                    direction = direction xor 1
                }
                result[queues[direction].first()] = current++
                queues[direction].removeFirst()
            }
        }

        for (i in arrival.indices) {
            goUntil(arrival[i] - 1)
            queues[state[i]].addLast(i)
            if (arrival[i] > current) {
                current = arrival[i]
                direction = exiting
            }
        }
        goUntil(Int.MAX_VALUE)
        return result
    }
}
