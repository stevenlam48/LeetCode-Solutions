package shortestpathinahiddengrid

// Time:  O(m * n)
// Space: O(m * n)

interface GridMaster {
    fun canMove(direction: Char): Boolean
    fun move(direction: Char)
    fun isTarget(): Boolean
}

class Solution {
    fun findShortestPath(master: GridMaster): Int {
        val maxM = 500
        val maxN = 500
        val start = maxM to maxN
        val target = intArrayOf(0, 0)
        val found = booleanArrayOf(false)
        val lookup = Array(2 * maxM + 1) { BooleanArray(2 * maxN + 1) }
        val grid = Array(2 * maxM + 1) { BooleanArray(2 * maxN + 1) }
        dfs(start, master, target, found, lookup, grid)
        if (!found[0]) {
            return -1
        }
        return biBfs(grid, start, target[0] to target[1])
    }

    private fun biBfs(grid: Array<BooleanArray>, start: Pair<Int, Int>, target: Pair<Int, Int>): Int {
        var left = hashSetOf(start)
        var right = hashSetOf(target)
        val lookup = Array(grid.size) { BooleanArray(grid[0].size) }
        var steps = 0
        while (left.isNotEmpty()) {
            for (pos in left) {
                lookup[pos.first][pos.second] = true
            }
            val newLeft = HashSet<Pair<Int, Int>>()
            for (pos in left) {
                if (pos in right) {
                    return steps
                }
                for ((_, dir) in directions) {
                    val nr = pos.first + dir.first
                    val nc = pos.second + dir.second
                    if (nr < 0 || nr >= grid.size || nc < 0 || nc >= grid[0].size) {
                        continue
                    }
                    if (!grid[nr][nc] || lookup[nr][nc]) {
                        continue
                    }
                    newLeft.add(nr to nc)
                }
            }
            left = newLeft
            ++steps
            if (left.size > right.size) {
                val tmp = left
                left = right
                right = tmp
            }
        }
        return -1
    }

    private fun dfs(
        pos: Pair<Int, Int>,
        master: GridMaster,
        target: IntArray,
        found: BooleanArray,
        lookup: Array<BooleanArray>,
        grid: Array<BooleanArray>
    ) {
        if (!found[0] && master.isTarget()) {
            found[0] = true
            target[0] = pos.first
            target[1] = pos.second
        }
        lookup[pos.first][pos.second] = true
        for ((d, dir) in directions) {
            if (!master.canMove(d)) {
                continue
            }
            val nei = (pos.first + dir.first) to (pos.second + dir.second)
            grid[nei.first][nei.second] = true
            if (lookup[nei.first][nei.second]) {
                continue
            }
            master.move(d)
            dfs(nei, master, target, found, lookup, grid)
            master.move(rollback[d]!!)
        }
    }

    companion object {
        private val directions = listOf(
            'L' to (0 to -1),
            'R' to (0 to 1),
            'U' to (-1 to 0),
            'D' to (1 to 0)
        )
        private val rollback = mapOf('L' to 'R', 'R' to 'L', 'U' to 'D', 'D' to 'U')
    }
}
