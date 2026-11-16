package minimumnumberofdaystodisconnectisland

// Time:  O(m * n)
// Space: O(m * n)

private val DIRECTIONS = arrayOf(
    intArrayOf(0, 1),
    intArrayOf(1, 0),
    intArrayOf(0, -1),
    intArrayOf(-1, 0)
)

private fun iterGetArticulationPoints(graph: Array<MutableList<Int>>, v: Int): List<Int> {
    var indexCounter = 0
    val index = IntArray(graph.size) { -1 }
    val lowlinks = IntArray(graph.size)
    val childrenCount = IntArray(graph.size)
    val isCut = BooleanArray(graph.size)
    val cutpoints = mutableListOf<Int>()

    fun iterDfs(start: Int, parent: Int) {
        val stk = java.util.ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, start, parent))
        while (!stk.isEmpty()) {
            val args = stk.removeLast()
            if (args[0] == 1) {
                val vertex = args[1]
                val p = args[2]
                index[vertex] = indexCounter
                lowlinks[vertex] = indexCounter++
                stk.addLast(intArrayOf(4, vertex, p))
                for (w in graph[vertex]) {
                    if (w == p) {
                        continue
                    }
                    stk.addLast(intArrayOf(2, w, vertex))
                }
            } else if (args[0] == 2) {
                val w = args[1]
                val vertex = args[2]
                if (index[w] == -1) {
                    ++childrenCount[vertex]
                    stk.addLast(intArrayOf(3, w, vertex))
                    stk.addLast(intArrayOf(1, w, vertex))
                } else {
                    lowlinks[vertex] = minOf(lowlinks[vertex], index[w])
                }
            } else if (args[0] == 3) {
                val w = args[1]
                val vertex = args[2]
                if (lowlinks[w] >= index[vertex]) {
                    isCut[vertex] = true
                }
                lowlinks[vertex] = minOf(lowlinks[vertex], lowlinks[w])
            } else if (args[0] == 4) {
                val vertex = args[1]
                val p = args[2]
                if ((p != -1 && isCut[vertex]) || (p == -1 && childrenCount[vertex] >= 2)) {
                    cutpoints.add(vertex)
                }
            }
        }
    }

    iterDfs(v, -1)
    return cutpoints
}

class Solution {
    fun minDays(grid: Array<IntArray>): Int {
        val r = grid.size
        val c = grid[0].size
        if (countIslands(grid) != 1) {
            return 0
        }
        val adj = Array(r * c) { mutableListOf<Int>() }
        var cnt = 0
        var idx = -1
        for (i in 0 until r) {
            for (j in 0 until c) {
                if (grid[i][j] == 0) {
                    continue
                }
                ++cnt
                if (idx == -1) {
                    idx = i * c + j
                }
                for (direction in DIRECTIONS) {
                    val ni = i + direction[0]
                    val nj = j + direction[1]
                    if (ni in 0 until r && nj in 0 until c && grid[ni][nj] == grid[i][j]) {
                        adj[i * c + j].add(ni * c + nj)
                    }
                }
            }
        }
        return if (cnt == 1 || iterGetArticulationPoints(adj, idx).isNotEmpty()) 1 else 2
    }

    private fun countIslands(grid: Array<IntArray>): Int {
        val lookup = Array(grid.size) { IntArray(grid[0].size) }
        var islandsCnt = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0 || lookup[i][j] != 0) {
                    continue
                }
                ++islandsCnt
                floodfill(grid, i, j, lookup)
            }
        }
        return islandsCnt
    }

    private fun floodfill(grid: Array<IntArray>, i: Int, j: Int, lookup: Array<IntArray>) {
        val stk = java.util.ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(i, j))
        lookup[i][j] = 1
        while (!stk.isEmpty()) {
            val cell = stk.removeLast()
            for (direction in DIRECTIONS) {
                val ni = cell[0] + direction[0]
                val nj = cell[1] + direction[1]
                if (ni !in grid.indices || nj !in grid[0].indices ||
                    grid[ni][nj] == 0 || lookup[ni][nj] != 0
                ) {
                    continue
                }
                lookup[ni][nj] = 1
                stk.addLast(intArrayOf(ni, nj))
            }
        }
    }
}
