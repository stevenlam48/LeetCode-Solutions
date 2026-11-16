package getbiggestthreerhombussumsinagrid

// Time:  O(m * n * min(m, n))
// Space: O(m * n)

import java.util.PriorityQueue

class Solution {
    fun getBiggestThree(grid: Array<IntArray>): IntArray {
        val left = Array(grid.size) { grid[it].clone() }
        val right = Array(grid.size) { grid[it].clone() }
        for (i in 1 until grid.size) {
            for (j in 0 until grid[0].size - 1) {
                left[i][j] += left[i - 1][j + 1]
            }
        }
        for (i in 1 until grid.size) {
            for (j in 1 until grid[0].size) {
                right[i][j] += right[i - 1][j - 1]
            }
        }
        val minHeap = PriorityQueue<Int>(compareBy { it })
        val lookup = HashSet<Int>()
        for (k in 0..(minOf(grid.size, grid[0].size) + 1) / 2) {
            for (i in k until grid.size - k) {
                for (j in k until grid[0].size - k) {
                    val total = if (k != 0) {
                        ((left[i][j - k] - left[i - k][j]) + (right[i][j + k] - right[i - k][j]) + grid[i - k][j]) +
                            ((left[i + k][j] - left[i][j + k]) + (right[i + k][j] - right[i][j - k]) - grid[i + k][j])
                    } else {
                        grid[i][j]
                    }
                    if (!lookup.add(total)) {
                        continue
                    }
                    minHeap.add(total)
                    if (minHeap.size == 4) {
                        lookup.remove(minHeap.poll())
                    }
                }
            }
        }
        val result = IntArray(minHeap.size)
        for (i in result.indices.reversed()) {
            result[i] = minHeap.poll()
        }
        return result
    }
}
