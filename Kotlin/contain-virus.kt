package containvirus
// Time:  O((m * n)^(4/3)), days = O((m * n)^(1/3))
// Space: O(m * n)

class Solution {
    fun containVirus(grid: Array<IntArray>): Int {
        var result = 0
        while (true) {
            val lookup = mutableSetOf<Pair<Int, Int>>()
            val regions = mutableListOf<MutableSet<Pair<Int, Int>>>()
            val frontiers = mutableListOf<MutableSet<Pair<Int, Int>>>()
            val perimeters = mutableListOf<Int>()
            for (r in grid.indices) {
                for (c in grid[r].indices) {
                    val p = Pair(r, c)
                    if (grid[r][c] == 1 && p !in lookup) {
                        regions.add(mutableSetOf())
                        frontiers.add(mutableSetOf())
                        perimeters.add(0)
                        dfs(grid, p, lookup, regions, frontiers, perimeters)
                    }
                }
            }
            if (regions.isEmpty()) {
                break
            }
            var triageIdx = 0
            for (i in frontiers.indices) {
                if (frontiers[i].size > frontiers[triageIdx].size) {
                    triageIdx = i
                }
            }
            for (i in regions.indices) {
                if (i == triageIdx) {
                    result += perimeters[i]
                    for (p in regions[i]) {
                        grid[p.first][p.second] = -1
                    }
                    continue
                }
                for (p in regions[i]) {
                    for (d in directions) {
                        val nr = p.first + d.first
                        val nc = p.second + d.second
                        if (nr < 0 || nr >= grid.size || nc < 0 || nc >= grid[nr].size) {
                            continue
                        }
                        if (grid[nr][nc] == 0) {
                            grid[nr][nc] = 1
                        }
                    }
                }
            }
        }
        return result
    }

    private fun dfs(
        grid: Array<IntArray>,
        p: Pair<Int, Int>,
        lookup: MutableSet<Pair<Int, Int>>,
        regions: MutableList<MutableSet<Pair<Int, Int>>>,
        frontiers: MutableList<MutableSet<Pair<Int, Int>>>,
        perimeters: MutableList<Int>
    ) {
        if (p in lookup) {
            return
        }
        lookup.add(p)
        regions.last().add(p)
        for (d in directions) {
            val nr = p.first + d.first
            val nc = p.second + d.second
            if (nr < 0 || nr >= grid.size || nc < 0 || nc >= grid[nr].size) {
                continue
            }
            if (grid[nr][nc] == 1) {
                dfs(grid, Pair(nr, nc), lookup, regions, frontiers, perimeters)
            } else if (grid[nr][nc] == 0) {
                frontiers.last().add(Pair(nr, nc))
                perimeters[perimeters.lastIndex]++
            }
        }
    }

    private val directions = listOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0))
}
