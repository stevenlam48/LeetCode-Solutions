package maximalscoreafterapplyingkoperations

import java.util.PriorityQueue

// Time:  O(n + klogn)
// Space: O(1)

// heap
class Solution {
    fun maxKelements(nums: IntArray, k: Int): Long {
        val pq = PriorityQueue<Int>(compareByDescending { it })
        for (x in nums) pq.add(x)

        var result = 0L
        var remaining = k
        while (remaining > 0 && pq.isNotEmpty()) {
            --remaining
            val x = pq.poll()
            result += x
            val nx = (x + 2) / 3
            if (nx == 0) continue
            pq.add(nx)
        }
        return result
    }
}
