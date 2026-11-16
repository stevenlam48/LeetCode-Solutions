package maximumtotalsumofkselectedelements

// Time:  O(nlogk)
// Space: O(k)

import java.util.PriorityQueue

class Solution {
    fun maxSum(nums: IntArray, k: Int, mul: Int): Long {
        val minHeap = PriorityQueue<Int>()
        for (x in nums) {
            minHeap.add(x)
            if (minHeap.size == k + 1) {
                minHeap.remove()
            }
        }
        var result = 0L
        while (minHeap.isNotEmpty()) {
            val x = minHeap.remove()
            result += x * maxOf(mul - minHeap.size, 1).toLong()
        }
        return result
    }
}
