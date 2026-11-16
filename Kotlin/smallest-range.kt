package smallestrange
// Time:  O(nlogk)
// Space: O(k)

import java.util.PriorityQueue

class Solution {
    fun smallestRange(nums: Array<IntArray>): IntArray {
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { (row, index) -> nums[row][index] })
        var left = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        for (row in nums.indices) {
            left = minOf(left, nums[row][0])
            right = maxOf(right, nums[row][0])
            minHeap.add(row to 0)
        }
        val result = intArrayOf(left, right)
        while (minHeap.isNotEmpty()) {
            val p = minHeap.poll()
            val next = p.second + 1
            if (next == nums[p.first].size) {
                break
            }
            minHeap.add(p.first to next)
            left = nums[minHeap.peek().first][minHeap.peek().second]
            right = maxOf(right, nums[p.first][next])
            if (right - left < result[1] - result[0]) {
                result[0] = left
                result[1] = right
            }
        }
        return result
    }
}
