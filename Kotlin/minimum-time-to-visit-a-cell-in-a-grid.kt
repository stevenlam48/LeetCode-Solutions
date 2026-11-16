package minimumtimetovisitacellinagrid

// Time:  O(m * n * log(m * n))
// Space: O(m * n)

import java.util.PriorityQueue

class Solution {
    fun minimumTime(grid: Array<IntArray>): Int {
        val directions = arrayOf(1 to 0, 0 to 1, -1 to 0, 0 to -1)
        if (minOf(grid[0][1], grid[1][0]) > 1) {
            return -1
        }
        val best = Array(grid.size) { IntArray(grid[0].size) { Int.MAX_VALUE } }
        best[0][0] = 0
        val heap = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenBy { it.third })
        heap.add(Triple(0, 0, 0))
        while (heap.isNotEmpty()) {
            val (current, i, j) = heap.poll()
            if (best[i][j] < current) {
                continue
            }
            if (i == grid.size - 1 && j == grid[0].size - 1) {
                break
            }
            for ((di, dj) in directions) {
                val ni = i + di
                val nj = j + dj
                if (ni !in grid.indices || nj !in grid[0].indices) {
                    continue
                }
                val arrival = maxOf(grid[ni][nj] + if (grid[ni][nj] % 2 == current % 2) 1 else 0, current + 1)
                if (best[ni][nj] > arrival) {
                    best[ni][nj] = arrival
                    heap.add(Triple(arrival, ni, nj))
                }
            }
        }
        return best[grid.size - 1][grid[0].size - 1]
    }
}
