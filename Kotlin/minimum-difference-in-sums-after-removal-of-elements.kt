package minimumdifferenceinsumsafterremovalofelements
// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun minimumDifference(nums: IntArray): Long {
        val n = nums.size / 3
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (i in 0 until n) {
            maxHeap.add(nums[i])
        }
        val prefix = LongArray(n + 1)
        for (i in 0 until n) {
            prefix[0] += nums[i]
        }
        for (i in 0 until n) {
            maxHeap.add(nums[i + n])
            val x = maxHeap.remove()
            prefix[i + 1] = prefix[i] - x + nums[i + n]
        }

        val minHeap = PriorityQueue<Int>(compareBy { it })
        for (i in nums.size - 1 downTo n * 2) {
            minHeap.add(nums[i])
        }
        var suffix = 0L
        for (i in n * 2 until nums.size) {
            suffix += nums[i]
        }
        var result = prefix[n] - suffix
        for (i in n - 1 downTo 0) {
            minHeap.add(nums[i + n])
            val x = minHeap.remove()
            suffix += -x + nums[i + n]
            result = minOf(result, prefix[i] - suffix)
        }
        return result
    }
}
