package makearraynondecreasingornonincreasing

// Time:  O(nlogn)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun convertArray(nums: IntArray): Int {
        return minOf(conversionCost(nums), conversionCost(nums.reversedArray()))
    }

    private fun conversionCost(nums: IntArray): Int {
        var result = 0
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        for (x in nums) {
            if (maxHeap.isNotEmpty() && x < maxHeap.peek()) {
                result += maxHeap.poll() - x
                maxHeap.offer(x)
            }
            maxHeap.offer(x)
        }
        return result
    }
}
