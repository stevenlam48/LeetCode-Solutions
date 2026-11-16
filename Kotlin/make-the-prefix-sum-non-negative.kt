package maketheprefixsumnonnegative

import java.util.PriorityQueue

// Time:  O(nlogn)
// Space: O(n)

// prefix sum, greedy, heap
class Solution {
    fun makePrefSumNonNegative(nums: IntArray): Int {
        val minHeap = PriorityQueue<Int>()
        var result = 0
        var prefix = 0L
        for (x in nums) {
            minHeap.add(x)
            prefix += x
            if (prefix < 0) {
                prefix -= minHeap.poll()
                ++result
            }
        }
        return result
    }
}
