package maximumsubsequencescore
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        var result = 0L
        var curr = 0L
        val nums = nums1.indices.map { nums1[it] to nums2[it] }
            .sortedByDescending { it.second }
        val minHeap = PriorityQueue<Int>(compareBy { it })
        for ((a, b) in nums) {
            curr += a
            minHeap.add(a)
            if (minHeap.size > k) {
                curr -= minHeap.poll()
            }
            if (minHeap.size == k) {
                result = maxOf(result, curr * b)
            }
        }
        return result
    }
}
