package thetimewhenthenetworkbecomesidle

// Time:  O(|V| + |E|) = O(|E|) since graph is connected, O(|E|) >= O(|V|)
// Space: O(|V| + |E|) = O(|E|)

class Solution {
    fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
        val adj = Array(patience.size) { ArrayList<Int>() }
        for (edge in edges) {
            adj[edge[0]].add(edge[1])
            adj[edge[1]].add(edge[0])
        }
        val lookup = BooleanArray(patience.size)
        lookup[0] = true
        var q = ArrayList<Int>()
        q.add(0)
        var result = 0
        var step = 1
        while (q.isNotEmpty()) {
            val newQ = ArrayList<Int>()
            for (u in q) {
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    lookup[v] = true
                    newQ.add(v)
                    result = Math.max(result, ((step * 2) - 1) / patience[v] * patience[v] + (step * 2))
                }
            }
            q = newQ
            ++step
        }
        return 1 + result
    }
}
