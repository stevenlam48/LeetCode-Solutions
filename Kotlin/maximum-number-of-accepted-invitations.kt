package maximumnumberofacceptedinvitations

// Time:  O(m * n * sqrt(m + n))
// Space: O(m * n)

private const val NIL = 0
private const val INF = Int.MAX_VALUE

private class BipGraph(private val m: Int, private val n: Int) {
    private val adj = Array(m + 1) { mutableListOf<Int>() }
    private lateinit var pairU: IntArray
    private lateinit var pairV: IntArray
    private lateinit var dist: IntArray

    fun addEdge(u: Int, v: Int) {
        adj[u].add(v)
    }

    fun hopcroftKarp(): Int {
        pairU = IntArray(m + 1) { NIL }
        pairV = IntArray(n + 1) { NIL }
        dist = IntArray(m + 1)
        var result = 0
        while (bfs()) {
            for (u in 1..m) {
                if (pairU[u] == NIL && dfs(u)) {
                    ++result
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
}

class Solution {
    fun maximumInvitations(grid: Array<IntArray>): Int {
        val graph = BipGraph(grid.size, grid[0].size)
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == 0) {
                    continue
                }
                graph.addEdge(i + 1, j + 1)
            }
        }
        return graph.hopcroftKarp()
    }
}
