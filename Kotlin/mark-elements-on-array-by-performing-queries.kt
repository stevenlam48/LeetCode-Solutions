package markelementsonarraybyperformingqueries

import java.util.PriorityQueue

// Time:  O(q + nlogn)
// Space: O(n)

// hash table, heap
class Solution {
    fun unmarkedSumArray(nums: IntArray, queries: Array<IntArray>): LongArray {
        var total = 0L
        for (x in nums) {
            total += x
        }
        val lookup = BooleanArray(nums.size)
        val minHeap = PriorityQueue<IntArray>(compareBy({ it[0] }, { it[1] }))
        for (i in nums.indices) {
            minHeap.add(intArrayOf(nums[i], i))
        }
        val result = LongArray(queries.size)
        for (i in queries.indices) {
            val idx = queries[i][0]
            val k = queries[i][1]
            if (!lookup[idx]) {
                lookup[idx] = true
                total -= nums[idx]
            }
            for (t in 0 until k) {
                while (minHeap.isNotEmpty()) {
                    val top = minHeap.poll()
                    val x = top[0]
                    val j = top[1]
                    if (lookup[j]) {
                        continue
                    }
                    lookup[j] = true
                    total -= x
                    break
                }
                if (minHeap.isEmpty()) {
                    break
                }
            }
            result[i] = total
        }
        return result
    }
}
