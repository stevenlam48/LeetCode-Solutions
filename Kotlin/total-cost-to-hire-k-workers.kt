package totalcosttohirekworkers

import java.util.PriorityQueue

// Time:  O(c + klogc)
// Space: O(c)

class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        var left = candidates
        var right = maxOf(costs.size - candidates, candidates) - 1
        val minHeap1 = PriorityQueue<Int>()
        for (i in 0 until left) {
            minHeap1.add(costs[i])
        }
        val minHeap2 = PriorityQueue<Int>()
        for (i in right + 1 until costs.size) {
            minHeap2.add(costs[i])
        }
        var result = 0L
        var kk = k
        while (kk-- > 0) {
            if (minHeap2.isEmpty() || (minHeap1.isNotEmpty() && minHeap1.peek() <= minHeap2.peek())) {
                result += minHeap1.poll()
                if (left <= right) {
                    minHeap1.add(costs[left++])
                }
            } else {
                result += minHeap2.poll()
                if (left <= right) {
                    minHeap2.add(costs[right--])
                }
            }
        }
        return result
    }
}
