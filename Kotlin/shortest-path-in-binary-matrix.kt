package shortestpathinbinarymatrix

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        var result = 0
        var q = ArrayDeque<Pair<Int, Int>>()
        q.addLast(0 to 0)
        while (q.isNotEmpty()) {
            ++result
            val nextDepth = ArrayDeque<Pair<Int, Int>>()
            while (q.isNotEmpty()) {
                val (i, j) = q.removeFirst()
                if (i in 0 until grid.size &&
                    j in 0 until grid[0].size &&
                    grid[i][j] == 0
                ) {
                    grid[i][j] = 1
                    if (i == grid.size - 1 && j == grid.size - 1) {
                        return result
                    }
                    for ((di, dj) in directions) {
                        nextDepth.addLast((i + di) to (j + dj))
                    }
                }
            }
            q = nextDepth
        }
        return -1
    }

    companion object {
        private val directions = arrayOf(
            -1 to -1, -1 to 0, -1 to 1,
            0 to -1, 0 to 1,
            1 to -1, 1 to 0, 1 to 1
        )
    }
}
