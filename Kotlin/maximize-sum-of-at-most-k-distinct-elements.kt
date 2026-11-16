package maximizesumofatmostkdistinctelements

// Time:  O(nlogk)
// Space: O(k)

import java.util.PriorityQueue

class Solution {
    fun maxKDistinct(nums: IntArray, k: Int): IntArray {
        val maxHeap = PriorityQueue<Int>(compareBy { it })
        for (x in nums.toHashSet()) {
            maxHeap.add(x)
            if (maxHeap.size == k + 1) {
                maxHeap.poll()
            }
        }
        val result = ArrayList<Int>(maxHeap.size)
        while (maxHeap.isNotEmpty()) {
            result.add(maxHeap.poll())
        }
        result.reverse()
        return result.toIntArray()
    }
}
