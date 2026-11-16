package maximumstudentstakingexam

// Time:  O(m * n * sqrt(m * n))
// Space: O(m * n)

class Solution {
    fun maxStudents(seats: Array<CharArray>): Int {
        val directions = arrayOf(
            intArrayOf(-1, -1), intArrayOf(0, -1), intArrayOf(1, -1),
            intArrayOf(-1, 1), intArrayOf(0, 1), intArrayOf(1, 1)
        )
        val rows = seats.size
        val cols = seats[0].size
        val lookup = HashMap<Int, Int>()
        var u = 0
        var v = 0
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (seats[i][j] != '.') {
                    continue
                }
                lookup[i * cols + j] = if (j % 2 == 0) ++u else ++v
            }
        }
        val g = BipGraph(rows * cols, rows * cols)
        for (i in 0 until rows) {
            var j = 0
            while (j < cols) {
                if (seats[i][j] == '.') {
                    for (d in directions) {
                        val ni = i + d[0]
                        val nj = j + d[1]
                        if (ni in 0 until rows && nj in 0 until cols && seats[ni][nj] == '.') {
                            g.addEdge(lookup[i * cols + j]!!, lookup[ni * cols + nj]!!)
                        }
                    }
                }
                j += 2
            }
        }
        return u + v - g.hopcroftKarp()
    }

    private class BipGraph(private val m: Int, private val n: Int) {
        private val adj = Array(m + 1) { ArrayList<Int>() }
        private lateinit var pairU: IntArray
        private lateinit var pairV: IntArray
        private lateinit var dist: IntArray

        fun addEdge(u: Int, v: Int) {
            adj[u].add(v)
        }

        fun hopcroftKarp(): Int {
            pairU = IntArray(m + 1)
            pairV = IntArray(n + 1)
            dist = IntArray(m + 1)
            var result = 0
            while (bfs()) {
                for (u in 1..m) {
                    if (pairU[u] == NIL && dfs(u)) {
                        result++
                    }
                }
            }
            return result
        }

        private fun bfs(): Boolean {
            val q = ArrayDeque<Int>()
            for (u in 1..m) {
                if (pairU[u] == NIL) {
                    dist[u] = 0
                    q.addLast(u)
                } else {
                    dist[u] = INF
                }
            }
            dist[NIL] = INF
            while (q.isNotEmpty()) {
                val u = q.removeFirst()
                if (dist[u] < dist[NIL]) {
                    for (v in adj[u]) {
                        if (dist[pairV[v]] == INF) {
                            dist[pairV[v]] = dist[u] + 1
                            q.addLast(pairV[v])
                        }
                    }
                }
            }
            return dist[NIL] != INF
        }

        private fun dfs(u: Int): Boolean {
            if (u != NIL) {
                for (v in adj[u]) {
                    if (dist[pairV[v]] == dist[u] + 1) {
                        if (dfs(pairV[v])) {
                            pairV[v] = u
                            pairU[u] = v
                            return true
                        }
                    }
                }
                dist[u] = INF
                return false
            }
            return true
        }

        companion object {
            private const val NIL = 0
            private const val INF = Int.MAX_VALUE
        }
    }
}
