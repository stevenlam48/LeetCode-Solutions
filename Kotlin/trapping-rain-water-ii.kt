package trappingrainwaterii

// Time:  O(m * n * log(m + n)) ~ O(m * n * log(m * n))
// Space: O(m * n)

import java.util.PriorityQueue

class Solution {
    private data class Cell(val i: Int, val j: Int, val height: Int)

    fun trapRainWater(heightMap: Array<IntArray>): Int {
        val m = heightMap.size
        if (m == 0) {
            return 0
        }
        val n = heightMap[0].size
        if (n == 0) {
            return 0
        }
        val visited = Array(m) { BooleanArray(n) }
        val heap = PriorityQueue<Cell>(compareBy { it.height })
        for (i in 0 until m) {
            heap.add(Cell(i, 0, heightMap[i][0]))
            visited[i][0] = true
            heap.add(Cell(i, n - 1, heightMap[i][n - 1]))
            visited[i][n - 1] = true
        }
        for (j in 1 until n - 1) {
            heap.add(Cell(0, j, heightMap[0][j]))
            visited[0][j] = true
            heap.add(Cell(m - 1, j, heightMap[m - 1][j]))
            visited[m - 1][j] = true
        }
        val directions = arrayOf(intArrayOf(0, -1), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(1, 0))
        var trap = 0
        while (heap.isNotEmpty()) {
            val c = heap.remove()
            for (d in directions) {
                val i = c.i + d[0]
                val j = c.j + d[1]
                if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
                    continue
                }
                heap.add(Cell(i, j, maxOf(c.height, heightMap[i][j])))
                visited[i][j] = true
                trap += maxOf(0, c.height - heightMap[i][j])
            }
        }
        return trap
    }
}
