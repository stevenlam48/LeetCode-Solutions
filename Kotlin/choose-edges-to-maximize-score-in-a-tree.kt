package chooseedgestomaximizescoreinatree

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxScore(edges: Array<IntArray>): Long {
        val adj = Array(edges.size) { mutableListOf<Pair<Int, Int>>() }
        for (i in 1 until edges.size) {
            adj[edges[i][0]].add(Pair(i, edges[i][1]))
        }

        val result = Array(adj.size) { LongArray(2) }
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, 0))
        while (stk.isNotEmpty()) {
            val top = stk.removeLast()
            val step = top[0]
            val u = top[1]
            if (step == 1) {
                if (adj[u].isEmpty()) {
                    continue
                }
                stk.addLast(intArrayOf(2, u))
                for ((v, _) in adj[u]) {
                    stk.addLast(intArrayOf(1, v))
                }
            } else if (step == 2) {
                var withoutU = 0L
                for ((v, _) in adj[u]) {
                    withoutU += maxOf(result[v][0], result[v][1])
                }
                var withU = 0L
                for (i in adj[u].indices) {
                    val v = adj[u][i].first
                    val w = adj[u][i].second
                    withU = maxOf(
                        withU,
                        withoutU - maxOf(result[v][0], result[v][1]) + (result[v][1] + w)
                    )
                }
                result[u][0] = withU
                result[u][1] = withoutU
            }
        }
        return maxOf(result[0][0], result[0][1])
    }
}
