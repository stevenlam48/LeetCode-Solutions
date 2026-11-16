package maximumnumberofeatenapples

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        val minHeap = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }))
        var result = 0
        var i = 0
        while (i < apples.size || minHeap.isNotEmpty()) {
            if (i < apples.size && apples[i] != 0) {
                minHeap.add(intArrayOf(i + days[i], i))
            }
            while (minHeap.isNotEmpty() &&
                (minHeap.peek()[0] <= i || apples[minHeap.peek()[1]] == 0)
            ) {
                minHeap.poll()
            }
            if (minHeap.isNotEmpty()) {
                --apples[minHeap.peek()[1]]
                ++result
            }
            ++i
        }
        return result
    }
}
