package catandmouseii

// Time:  O((m * n)^2 * (m + n))
// Space: O((m * n)^2)

class Solution {
    private val DRAW = 0
    private val MOUSE = 1
    private val CAT = 2

    fun canMouseWin(grid: Array<String>, catJump: Int, mouseJump: Int): Boolean {
        val directions = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, -1),
            intArrayOf(-1, 0)
        )

        val R = grid.size
        val C = grid[0].length
        val N = R * C
        val walls = HashSet<Int>()
        var FOOD = -1
        var MOUSE_START = -1
        var CAT_START = -1
        for (r in 0 until R) {
            for (c in 0 until C) {
                when (grid[r][c]) {
                    'M' -> MOUSE_START = r * C + c
                    'C' -> CAT_START = r * C + c
                    'F' -> FOOD = r * C + c
                    '#' -> walls.add(r * C + c)
                }
            }
        }

        val graph = Array(N) { Array(2) { mutableListOf<Int>() } }
        val jump = intArrayOf(mouseJump, catJump)
        for (r in 0 until R) {
            for (c in 0 until C) {
                if (grid[r][c] == '#') {
                    continue
                }
                val pos = r * C + c
                for (t in intArrayOf(MOUSE, CAT)) {
                    for (dir in directions) {
                        val dr = dir[0]
                        val dc = dir[1]
                        for (d in 0..jump[t - 1]) {
                            val nr = r + dr * d
                            val nc = c + dc * d
                            if (!(0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] != '#')) {
                                break
                            }
                            graph[pos][t - 1].add(nr * C + nc)
                        }
                    }
                }
            }
        }

        val degree = Array(N) { Array(N) { IntArray(2) } }
        for (m in 0 until N) {
            for (c in 0 until N) {
                degree[m][c][MOUSE - 1] = graph[m][MOUSE - 1].size
                degree[m][c][CAT - 1] = graph[c][CAT - 1].size
            }
        }

        val color = Array(N) { Array(N) { IntArray(2) } }
        val q = ArrayDeque<IntArray>()
        for (i in 0 until N) {
            if (walls.contains(i) || i == FOOD) {
                continue
            }
            color[FOOD][i][CAT - 1] = MOUSE
            q.addLast(intArrayOf(FOOD, i, CAT, MOUSE))
            color[i][FOOD][MOUSE - 1] = CAT
            q.addLast(intArrayOf(i, FOOD, MOUSE, CAT))
            for (t in intArrayOf(MOUSE, CAT)) {
                color[i][i][t - 1] = CAT
                q.addLast(intArrayOf(i, i, t, CAT))
            }
        }
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            val i = cur[0]
            val j = cur[1]
            val t = cur[2]
            val c = cur[3]
            for (p in parents(graph, i, j, t)) {
                val ni = p[0]
                val nj = p[1]
                val nt = p[2]
                if (color[ni][nj][nt - 1] != DRAW) {
                    continue
                }
                if (nt == c) {
                    color[ni][nj][nt - 1] = c
                    q.addLast(intArrayOf(ni, nj, nt, c))
                    continue
                }
                degree[ni][nj][nt - 1] -= 1
                if (degree[ni][nj][nt - 1] == 0) {
                    color[ni][nj][nt - 1] = c
                    q.addLast(intArrayOf(ni, nj, nt, c))
                }
            }
        }
        return color[MOUSE_START][CAT_START][MOUSE - 1] == MOUSE
    }

    private fun parents(graph: Array<Array<MutableList<Int>>>, m: Int, c: Int, t: Int): List<IntArray> {
        val result = mutableListOf<IntArray>()
        if (t == CAT) {
            for (nm in graph[m][(MOUSE xor CAT xor t) - 1]) {
                result.add(intArrayOf(nm, c, MOUSE xor CAT xor t))
            }
        } else {
            for (nc in graph[c][(MOUSE xor CAT xor t) - 1]) {
                result.add(intArrayOf(m, nc, MOUSE xor CAT xor t))
            }
        }
        return result
    }
}
