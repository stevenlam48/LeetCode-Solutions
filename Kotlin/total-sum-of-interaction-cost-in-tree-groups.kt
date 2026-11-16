package totalsumofinteractioncostintreegroups

// Time:  O(n * g)
// Space: O(n * g)

class Solution {
    fun interactionCosts(n: Int, edges: Array<IntArray>, group: IntArray): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val mx = group.max()
        val total = LongArray(mx)
        for (x in group) {
            ++total[x - 1]
        }
        var result = 0L

        val order = ArrayList<Int>(n)
        order.add(0)
        val parent = IntArray(n) { -1 }
        var idx = 0
        while (idx < order.size) {
            val u = order[idx]
            for (v in adj[u]) {
                if (v == parent[u]) {
                    continue
                }
                parent[v] = u
                order.add(v)
            }
            ++idx
        }

        val cnt = Array(n) { LongArray(mx) }
        for (i in order.size - 1 downTo 0) {
            val u = order[i]
            ++cnt[u][group[u] - 1]
            for (v in adj[u]) {
                if (u != parent[v]) {
                    continue
                }
                for (k in cnt[v].indices) {
                    result += cnt[v][k] * (total[k] - cnt[v][k])
                    cnt[u][k] += cnt[v][k]
                }
            }
        }
        return result
    }
}
