package minimizemaximumvalueinagrid

// Time:  O((m * n) * log(m * n))
// Space: O(m * n)

class Solution {
    fun minScore(grid: Array<IntArray>): Array<IntArray> {
        val indices = ArrayList<Pair<Int, Int>>(grid.size * grid[0].size)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                indices.add(i to j)
            }
        }
        indices.sortWith(Comparator { a, b ->
            grid[a.first][a.second].compareTo(grid[b.first][b.second])
        })
        val rowMax = IntArray(grid.size)
        val colMax = IntArray(grid[0].size)
        for ((i, j) in indices) {
            val value = maxOf(rowMax[i], colMax[j]) + 1
            grid[i][j] = value
            rowMax[i] = value
            colMax[j] = value
        }
        return grid
    }
}
