package designneighborsumservice

// Time:  ctor:        O(n^2)
//        adjacentSum: O(1)
//        diagonalSum: O(1)
// Space: O(n^2)

class neighborSum(grid: Array<IntArray>) {
    private val grid = grid
    private val lookup = Array(grid.size * grid[0].size) { IntArray(2) }

    init {
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                lookup[grid[i][j]] = intArrayOf(i, j)
            }
        }
    }

    fun adjacentSum(value: Int): Int = sum(value, ADJACENTS)

    fun diagonalSum(value: Int): Int = sum(value, DIAGONALS)

    private fun sum(value: Int, directions: Array<IntArray>): Int {
        val (i, j) = lookup[value]
        var total = 0
        for ((di, dj) in directions) {
            val ni = i + di
            val nj = j + dj
            if (!(0 <= ni && ni < grid.size && 0 <= nj && nj < grid[0].size)) {
                continue
            }
            total += grid[ni][nj]
        }
        return total
    }

    companion object {
        private val ADJACENTS = arrayOf(
            intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1)
        )
        private val DIAGONALS = arrayOf(
            intArrayOf(1, 1), intArrayOf(1, -1), intArrayOf(-1, 1), intArrayOf(-1, -1)
        )
    }
}
