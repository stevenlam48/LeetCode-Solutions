package divideanarrayintosubarrayswithminimumcostii
// Time:  O(nlogd)
// Space: O(d)

import java.util.PriorityQueue

class Solution {
    fun minimumCost(nums: IntArray, k: Int, dist: Int): Long {
        val pairComparator = compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second }
        val maxHeap = PriorityQueue<Pair<Int, Int>>(pairComparator.reversed())
        val minHeap = PriorityQueue<Pair<Int, Int>>(pairComparator)
        val total1 = IntArray(1)
        val total2 = IntArray(1)
        var mn = Long.MAX_VALUE
        var curr = 0L
        for (i in 1 until nums.size) {
            maxHeap.add(nums[i] to -i)
            curr += nums[i]
            if (i > k - 1) {
                val (x, idx) = getTop(maxHeap, total1, i - (1 + dist))
                maxHeap.poll()
                curr -= x
                minHeap.add(x to idx)
            }
            if (i > 1 + dist) {
                val oldIndex = i - (1 + dist)
                val top = getTop(minHeap, total2, oldIndex)
                if (top.first < nums[oldIndex] || (top.first == nums[oldIndex] && top.second <= -oldIndex)) {
                    lazyDelete(minHeap, total2, oldIndex)
                } else {
                    lazyDelete(maxHeap, total1, oldIndex)
                    curr -= nums[oldIndex] - minHeap.peek().first
                    maxHeap.add(minHeap.poll())
                }
            }
            if (i >= k - 1) {
                mn = minOf(mn, curr)
            }
        }
        return nums[0] + mn
    }

    private fun getTop(heap: PriorityQueue<Pair<Int, Int>>, total: IntArray, d: Int): Pair<Int, Int> {
        while (-heap.peek().second < d) {
            heap.poll()
            --total[0]
        }
        return heap.peek()
    }

    private fun lazyDelete(heap: PriorityQueue<Pair<Int, Int>>, total: IntArray, d: Int) {
        ++total[0]
        if (total[0] <= heap.size - total[0]) {
            return
        }
        val newHeap = PriorityQueue<Pair<Int, Int>>(heap.comparator())
        while (heap.isNotEmpty()) {
            val x = heap.poll()
            if (-x.second <= d) {
                --total[0]
                continue
            }
            newHeap.add(x)
        }
        heap.clear()
        heap.addAll(newHeap)
    }
}
