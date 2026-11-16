package shortestpathtogetfood

// Time:  O(m * n)
// Space: O(m + n)

class Solution {
    fun getFood(grid: Array<CharArray>): Int {
        var q = ArrayList<Pair<Int, Int>>()
        outer@ for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (grid[r][c] == '*') {
                    q.add(r to c)
                    break@outer
                }
            }
        }

        var result = 0
        while (q.isNotEmpty()) {
            ++result
            val newQ = ArrayList<Pair<Int, Int>>()
            for ((r, c) in q) {
                for ((dr, dc) in directions) {
                    val nr = r + dr
                    val nc = c + dc
                    if (!(nr in grid.indices && nc in grid[0].indices && grid[nr][nc] != 'X')) {
                        continue
                    }
                    if (grid[nr][nc] == '#') {
                        return result
                    }
                    grid[nr][nc] = 'X'
                    newQ.add(nr to nc)
                }
            }
            q = newQ
        }
        return -1
    }

    companion object {
        private val directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
    }
}
