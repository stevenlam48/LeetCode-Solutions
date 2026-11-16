package construct2dgridmatchinggraphlayout
// Time:  O(n)
// Space: O(n)

class Solution {
    fun constructGridLayout(n: Int, edges: Array<IntArray>): Array<IntArray> {
        val adj = Array(n) { mutableListOf<Int>() }
        fun bfs(start: Int): IntArray {
            val dist = IntArray(n)
            dist[start] = 1
            var q = listOf(start)
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    for (v in adj[u]) {
                        if (dist[v] != 0) {
                            continue
                        }
                        dist[v] = dist[u] + 1
                        newQ.add(v)
                    }
                }
                q = newQ
            }
            return dist
        }

        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val mn = adj.minOf { it.size }
        val corners = mutableListOf<Int>()
        for (u in 0 until n) {
            if (adj[u].size == mn) {
                corners.add(u)
            }
        }
        val dist1 = bfs(corners[0])
        val orderedCorners = corners.sortedWith(compareBy { dist1[it] })
        val dist2 = bfs(orderedCorners[1])
        val c = dist1[orderedCorners[1]]
        val r = n / c
        val result = Array(r) { IntArray(c) }
        for (u in 0 until n) {
            val i = (dist1[u] + dist2[u] - (1 + c)) / 2
            val j = dist1[u] - 1 - i
            result[i][j] = u
        }
        return result
    }
}
