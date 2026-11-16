package minimumedgetogglesonatree

// Time:  O(n)
// Space: O(n)

// greedy, topological sort, bitmasks
class Solution {
    fun minimumFlips(n: Int, edges: Array<IntArray>, start: String, target: String): IntArray {
        val diff = IntArray(n)
        for (i in 0 until n) {
            if (start[i] != target[i]) {
                diff[i] = 1
            }
        }
        if (diff.sum() % 2 != 0) {
            return intArrayOf(-1)
        }
        val degree = IntArray(n)
        val adj = IntArray(n)
        val edge = IntArray(n)
        for (idx in edges.indices) {
            val u = edges[idx][0]
            val v = edges[idx][1]
            ++degree[u]
            ++degree[v]
            adj[u] = adj[u] xor v
            adj[v] = adj[v] xor u
            edge[u] = edge[u] xor idx
            edge[v] = edge[v] xor idx
        }
        val lookup = BooleanArray(edges.size)
        for (i in 0 until n) {
            var u = i
            while (degree[u] == 1) {
                val v = adj[u]
                val idx = edge[u]
                --degree[u]
                --degree[v]
                adj[u] = adj[u] xor v
                adj[v] = adj[v] xor u
                edge[u] = edge[u] xor idx
                edge[v] = edge[v] xor idx
                if (diff[u] != 0) {
                    diff[u] = diff[u] xor 1
                    diff[v] = diff[v] xor 1
                    lookup[idx] = true
                }
                u = v
            }
        }
        val result = ArrayList<Int>()
        for (i in lookup.indices) {
            if (lookup[i]) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
