package maximizesumofweightsafteredgeremovals

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximizeSumOfWeights(edges: Array<IntArray>, k: Int): Long {
        val adj = Array(edges.size + 1) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(e[1] to e[2])
            adj[e[1]].add(e[0] to e[2])
        }
        val cnt = Array(adj.size) { 0L to 0L }
        val stk = ArrayDeque<Triple<Int, Int, Int>>()
        stk.addLast(Triple(1, 0, -1))
        while (stk.isNotEmpty()) {
            val (step, u, p) = stk.removeLast()
            if (step == 1) {
                stk.addLast(Triple(2, u, p))
                for ((v, _) in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    stk.addLast(Triple(1, v, u))
                }
            } else if (step == 2) {
                var curr = 0L
                val diff = mutableListOf<Long>()
                for ((v, w) in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    curr += cnt[v].first
                    diff.add(maxOf(cnt[v].second + w - cnt[v].first, 0L))
                }
                diff.sortDescending()
                var first = curr
                for (i in 0 until minOf(k, diff.size)) {
                    first += diff[i]
                }
                var second = curr
                for (i in 0 until minOf(k - 1, diff.size)) {
                    second += diff[i]
                }
                cnt[u] = first to second
            }
        }
        return cnt[0].first
    }
}
