package minimumcosttorepairedgestotraverseagraph

// Time:  O((n + m) * logr)
// Space: O(n + m)

class Solution {
    fun minCost(n: Int, edges: Array<IntArray>, k: Int): Int {
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2]))
            adj[e[1]].add(Pair(e[0], e[2]))
        }

        fun bfs(x: Int): Boolean {
            val lookup = BooleanArray(n)
            lookup[0] = true
            var q = mutableListOf(0)
            var d = 0
            while (q.isNotEmpty()) {
                if (d == k + 1) {
                    break
                }
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    if (u == n - 1) {
                        return true
                    }
                    for ((v, w) in adj[u]) {
                        if (w > x || lookup[v]) {
                            continue
                        }
                        lookup[v] = true
                        newQ.add(v)
                    }
                }
                q = newQ
                ++d
            }
            return false
        }

        val maxWeight = edges.maxOf { it[2] }
        var left = edges.minOf { it[2] }
        var right = maxWeight
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (bfs(mid)) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left != maxWeight + 1) left else -1
    }
}
