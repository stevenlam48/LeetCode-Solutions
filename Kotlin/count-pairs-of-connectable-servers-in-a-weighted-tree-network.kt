package countpairsofconnectableserversinaweightedtreenetwork

// Time:  O(n^2)
// Space: O(n)

// iterative dfs
class Solution {
    fun countPairsOfConnectableServers(edges: Array<IntArray>, signalSpeed: Int): IntArray {
        val adj = Array(edges.size + 1) { ArrayList<IntArray>() }
        for (e in edges) {
            adj[e[0]].add(intArrayOf(e[1], e[2]))
            adj[e[1]].add(intArrayOf(e[0], e[2]))
        }
        fun iterDfs(u0: Int, p0: Int, dist0: Int): Int {
            var result = 0
            val stk = ArrayDeque<IntArray>()
            stk.addLast(intArrayOf(u0, p0, dist0))
            while (stk.isNotEmpty()) {
                val cur = stk.removeLast()
                val u = cur[0]
                val p = cur[1]
                val dist = cur[2]
                if (dist % signalSpeed == 0) {
                    ++result
                }
                for (nxt in adj[u]) {
                    val v = nxt[0]
                    val w = nxt[1]
                    if (v == p) {
                        continue
                    }
                    stk.addLast(intArrayOf(v, u, dist + w))
                }
            }
            return result
        }

        val result = IntArray(edges.size + 1)
        for (u in result.indices) {
            var curr = 0
            for (nxt in adj[u]) {
                val v = nxt[0]
                val w = nxt[1]
                val cnt = iterDfs(v, u, w)
                result[u] += curr * cnt
                curr += cnt
            }
        }
        return result
    }
}
