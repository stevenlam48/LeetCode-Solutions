package numberofdistinctislandsii

// Time:  O((m * n) * log(m * n))
// Space: O(m * n)

class Solution {
    fun numDistinctIslands2(grid: Array<IntArray>): Int {
        val islands = mutableSetOf<List<Pair<Int, Int>>>()
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    val island = mutableListOf<Pair<Int, Int>>()
                    if (dfs(i, j, grid, island)) {
                        islands.add(normalize(island))
                    }
                }
            }
        }
        return islands.size
    }

    private fun dfs(i: Int, j: Int, grid: Array<IntArray>, island: MutableList<Pair<Int, Int>>): Boolean {
        if (i !in grid.indices || j !in grid[0].indices || grid[i][j] <= 0) {
            return false
        }
        grid[i][j] *= -1
        island.add(Pair(i, j))
        for ((di, dj) in DIRECTIONS) {
            dfs(i + di, j + dj, grid, island)
        }
        return true
    }

    private fun normalize(island: List<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val shapes = Array(8) { mutableListOf<Pair<Int, Int>>() }
        for ((x, y) in island) {
            val rotationsAndReflections = arrayOf(
                Pair(x, y), Pair(x, -y), Pair(-x, y), Pair(-x, -y),
                Pair(y, x), Pair(y, -x), Pair(-y, x), Pair(-y, -x)
            )
            for (i in rotationsAndReflections.indices) {
                shapes[i].add(rotationsAndReflections[i])
            }
        }
        val comparator = compareBy<Pair<Int, Int>>({ it.first }, { it.second })
        for (shape in shapes) {
            shape.sortWith(comparator)
            val origin = shape.first()
            for (i in shape.indices) {
                shape[i] = Pair(shape[i].first - origin.first, shape[i].second - origin.second)
            }
        }
        var result: List<Pair<Int, Int>> = shapes[0]
        for (i in 1 until shapes.size) {
            if (compareShapes(shapes[i], result) < 0) {
                result = shapes[i]
            }
        }
        return result
    }

    private fun compareShapes(a: List<Pair<Int, Int>>, b: List<Pair<Int, Int>>): Int {
        for (i in a.indices) {
            val xComparison = a[i].first.compareTo(b[i].first)
            if (xComparison != 0) {
                return xComparison
            }
            val yComparison = a[i].second.compareTo(b[i].second)
            if (yComparison != 0) {
                return yComparison
            }
        }
        return a.size.compareTo(b.size)
    }

    companion object {
        private val DIRECTIONS = arrayOf(
            intArrayOf(1, 0), intArrayOf(-1, 0),
            intArrayOf(0, 1), intArrayOf(0, -1)
        )
    }
}
