package minimizedeviationinarray

import java.util.Collections
import java.util.PriorityQueue

// Time:  O((n * log(max_num)) * logn)
// Space: O(n)

class Solution {
    fun minimumDeviation(nums: IntArray): Int {
        val evens = IntArray(nums.size) { if (nums[it] % 2 != 0) 2 * nums[it] else nums[it] }
        var minElem = evens.min()
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        for (x in evens) {
            maxHeap.add(x)
        }
        var result = Int.MAX_VALUE
        while (maxHeap.size == nums.size) {
            val num = maxHeap.poll()
            result = minOf(result, num - minElem)
            if (num % 2 == 0) {
                minElem = minOf(minElem, num / 2)
                maxHeap.add(num / 2)
            }
        }
        return result
    }
}
