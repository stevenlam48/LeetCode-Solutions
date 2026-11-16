package minimumoperationstoexceedthresholdvalueii

// Time:  O(nlogn)
// Space: O(n)

// simulation, heap
class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        var result = 0
        val minHeap = java.util.PriorityQueue<Long>()
        for (x in nums) {
            minHeap.add(x.toLong())
        }
        while (minHeap.isNotEmpty()) {
            if (minHeap.peek() >= k) {
                break
            }
            val mn1 = minHeap.poll()
            val mn2 = minHeap.poll()
            minHeap.add(2 * mn1 + mn2)
            ++result
        }
        return result
    }
}
