package countthenumberofkbigindices
// Time:  O(nlogk)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun kBigIndices(nums: IntArray, k: Int): Int {
        val right = BooleanArray(nums.size)
        val maxHeap1 = PriorityQueue<Int>(compareByDescending { it })
        for (i in nums.indices.reversed()) {
            if (maxHeap1.size == k && nums[i] > maxHeap1.peek()) {
                right[i] = true
            }
            maxHeap1.offer(nums[i])
            if (maxHeap1.size == k + 1) {
                maxHeap1.poll()
            }
        }
        var result = 0
        val maxHeap2 = PriorityQueue<Int>(compareByDescending { it })
        for (i in nums.indices) {
            if (maxHeap2.size == k && nums[i] > maxHeap2.peek() && right[i]) {
                ++result
            }
            maxHeap2.offer(nums[i])
            if (maxHeap2.size == k + 1) {
                maxHeap2.poll()
            }
        }
        return result
    }
}
