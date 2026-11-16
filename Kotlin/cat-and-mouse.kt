package catandmouse

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    private val HOLE = 0
    private val MOUSE_START = 1
    private val CAT_START = 2
    private val DRAW = 0
    private val MOUSE = 1
    private val CAT = 2

    fun catMouseGame(graph: Array<IntArray>): Int {
        val n = graph.size
        val degree = Array(n) { Array(n) { IntArray(2) } }
        val ignore = graph[HOLE].toHashSet()
        for (m in 0 until n) {
            for (c in 0 until n) {
                degree[m][c][MOUSE - 1] = graph[m].size
                degree[m][c][CAT - 1] = graph[c].size - (if (ignore.contains(c)) 1 else 0)
            }
        }
        val color = Array(n) { Array(n) { IntArray(2) } }
        val q = ArrayDeque<IntArray>()
        for (i in 0 until n) {
            if (i == HOLE) {
                continue
            }
            color[HOLE][i][CAT - 1] = MOUSE
            q.addLast(intArrayOf(HOLE, i, CAT, MOUSE))
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
        return color[MOUSE_START][CAT_START][MOUSE - 1]
    }

    private fun parents(graph: Array<IntArray>, m: Int, c: Int, t: Int): List<IntArray> {
        val result = mutableListOf<IntArray>()
        if (t == CAT) {
            for (nm in graph[m]) {
                result.add(intArrayOf(nm, c, MOUSE xor CAT xor t))
            }
        } else {
            for (nc in graph[c]) {
                if (nc != HOLE) {
                    result.add(intArrayOf(m, nc, MOUSE xor CAT xor t))
                }
            }
        }
        return result
    }
}
