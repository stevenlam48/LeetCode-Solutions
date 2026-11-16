package zeroarraytransformationiii

import java.util.PriorityQueue

// Time:  O(n + qlogq)
// Space: O(q)

// sort, heap, greedy
class Solution {
    fun maxRemoval(nums: IntArray, queries: Array<IntArray>): Int {
        queries.sortWith(compareBy({ it[0] }, { it[1] }))
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        val minHeap = PriorityQueue<Int>()
        var idx = 0
        for (i in nums.indices) {
            while (idx < queries.size && queries[idx][0] <= i) {
                maxHeap.add(queries[idx][1])
                ++idx
            }
            while (minHeap.isNotEmpty() && minHeap.peek() < i) {
                minHeap.poll()
            }
            while (minHeap.size < nums[i]) {
                if (maxHeap.isEmpty() || maxHeap.peek() < i) {
                    return -1
                }
                minHeap.add(maxHeap.peek())
                maxHeap.poll()
            }
        }
        return maxHeap.size
    }
}
