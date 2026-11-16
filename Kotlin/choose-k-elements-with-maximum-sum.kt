package choosekelementswithmaximumsum

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun findMaxSum(nums1: IntArray, nums2: IntArray, k: Int): LongArray {
        val result = LongArray(nums1.size)
        val minHeap = java.util.PriorityQueue<Int>()
        val idxs = nums1.indices.sortedBy { nums1[it] }
        var total = 0L
        var j = 0
        for (i in idxs.indices) {
            while (nums1[idxs[j]] < nums1[idxs[i]]) {
                total += nums2[idxs[j]]
                minHeap.add(nums2[idxs[j]])
                if (minHeap.size == k + 1) {
                    total -= minHeap.poll()
                }
                ++j
            }
            result[idxs[i]] = total
        }
        return result
    }
}
