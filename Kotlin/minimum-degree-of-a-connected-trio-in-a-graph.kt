package minimumdegreeofaconnectedtrioinagraph

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun minTrioDegree(n: Int, edges: Array<IntArray>): Int {
        val adj = Array(n + 1) { HashSet<Int>() }
        val degree = IntArray(n + 1)
        for (e in edges) {
            adj[minOf(e[0], e[1])].add(maxOf(e[0], e[1]))
            ++degree[e[0]]
            ++degree[e[1]]
        }
        var result = Int.MAX_VALUE
        for (u in 1..n) {
            for (v in adj[u]) {
                for (w in adj[u]) {
                    if (v < w && adj[v].contains(w)) {
                        result = minOf(result, degree[u] + degree[v] + degree[w] - 6)
                    }
                }
            }
        }
        return if (result != Int.MAX_VALUE) result else -1
    }
}
