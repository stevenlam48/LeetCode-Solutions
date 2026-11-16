package networkrecoverypathways
// Time:  O((n + e) * logr), r = max(e[2] for e in edges)
// Space: O(n + e)

class Solution {
    fun findMaxPathScore(edges: Array<IntArray>, online: BooleanArray, k: Long): Int {
        val adj = Array(online.size) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(e[1] to e[2])
        }
        val inDegree = IntArray(adj.size)
        for (u in adj.indices) {
            for ((v, _) in adj[u]) {
                ++inDegree[v]
            }
        }
        var q = mutableListOf<Int>()
        for (u in adj.indices) {
            if (inDegree[u] == 0) {
                q.add(u)
            }
        }
        val order = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (u in q) {
                order.add(u)
                for ((v, _) in adj[u]) {
                    --inDegree[v]
                    if (inDegree[v] != 0) {
                        continue
                    }
                    newQ.add(v)
                }
            }
            q = newQ
        }
        fun check(x: Int): Boolean {
            val dist = LongArray(adj.size) { Long.MAX_VALUE }
            dist[0] = 0
            for (u in order) {
                if (dist[u] == Long.MAX_VALUE) {
                    continue
                }
                for ((v, c) in adj[u]) {
                    if (c < x || !online[v]) {
                        continue
                    }
                    dist[v] = minOf(dist[v], dist[u] + c)
                }
            }
            return dist.last() <= k
        }
        var left = Int.MAX_VALUE
        var right = 0
        for (u in adj.indices) {
            for ((_, c) in adj[u]) {
                left = minOf(left, c)
                right = maxOf(right, c)
            }
        }
        var l = left
        var r = right
        while (l <= r) {
            val mid = l + (r - l) / 2
            if (!check(mid)) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        val result = r
        return if (result >= left) result else -1
    }
}
