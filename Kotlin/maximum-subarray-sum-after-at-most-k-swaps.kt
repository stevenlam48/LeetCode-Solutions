package maximumsubarraysumafteratmostkswaps

// Time:  O(n^2 * logk)
// Space: O(n)

import java.util.PriorityQueue

class Solution {
    fun maxSum(nums: IntArray, k: Int): Long {
        fun update(heap: PriorityQueue<Int>, total: Long, x: Int): Long {
            if (k == 0) {
                return total
            }
            heap.add(x)
            var newTotal = total + x
            if (heap.size == k + 1) {
                newTotal -= heap.poll()
            }
            return newTotal
        }

        val count = nums.count { it < 0 }
        if (count == nums.size) {
            return nums.maxOrNull()!!.toLong()
        }
        if (count <= k) {
            return nums.sumOf { if (it >= 0) it.toLong() else 0L }
        }
        val prefix = LongArray(nums.size + 1)
        for (i in nums.indices) {
            prefix[i + 1] = prefix[i] + nums[i]
        }
        var result = 0L
        val dp = LongArray(nums.size)
        for (i in nums.indices) {
            val maxHeap = PriorityQueue<Int>(compareBy { it })
            var total1 = 0L
            for (j in i until nums.size) {
                if (nums[j] < 0) {
                    total1 = update(maxHeap, total1, -nums[j])
                }
                dp[j] = -total1
            }
            val minHeap = PriorityQueue<Int>(compareBy { it })
            var total2 = 0L
            for (j in 0 until i) {
                if (nums[j] >= 0) {
                    total2 = update(minHeap, total2, nums[j])
                }
            }
            for (j in nums.size - 1 downTo i) {
                result = maxOf(result, prefix[j + 1] - prefix[i] - dp[j] + total2)
                if (nums[j] >= 0) {
                    total2 = update(minHeap, total2, nums[j])
                    result = maxOf(result, total2)
                }
            }
        }
        return result
    }
}
