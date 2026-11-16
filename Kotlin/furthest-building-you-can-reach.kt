package furthestbuildingyoucanreach

// Time:  O(nlogk)
// Space: O(k)

class Solution {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        val minHeap = java.util.PriorityQueue<Int>()
        var bricksLeft = bricks
        for (i in 0 until heights.size - 1) {
            val diff = heights[i + 1] - heights[i]
            if (diff > 0) {
                minHeap.add(diff)
            }
            if (minHeap.size <= ladders) {
                continue
            }
            val h = minHeap.poll()
            bricksLeft -= h
            if (bricksLeft < 0) {
                return i
            }
        }
        return heights.size - 1
    }
}
