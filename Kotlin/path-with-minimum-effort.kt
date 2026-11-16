package pathwithminimumeffort

import java.util.PriorityQueue
import kotlin.math.abs
import kotlin.math.max

// Time:  O(m * n * log(m * n))
// Space: O(m * n)

class Solution {
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val directions = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(-1, 0))

        val dist = Array(heights.size) { IntArray(heights[0].size) { Int.MAX_VALUE } }
        dist[0][0] = 0
        val minHeap = PriorityQueue<IntArray>(compareBy { it[0] })
        minHeap.add(intArrayOf(0, 0, 0))
        val lookup = Array(heights.size) { BooleanArray(heights[0].size) }
        while (minHeap.isNotEmpty()) {
            val (d, r, c) = minHeap.poll()
            if (lookup[r][c]) {
                continue
            }
            lookup[r][c] = true
            if (r == heights.size - 1 && c == heights[0].size - 1) {
                return d
            }
            for (dir in directions) {
                val nr = r + dir[0]
                val nc = c + dir[1]
                if (!(0 <= nr && nr < heights.size &&
                        0 <= nc && nc < heights[0].size &&
                        !lookup[nr][nc])) {
                    continue
                }
                val nd = max(d, abs(heights[nr][nc] - heights[r][c]))
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd
                    minHeap.add(intArrayOf(nd, nr, nc))
                }
            }
        }
        return -1
    }
}
