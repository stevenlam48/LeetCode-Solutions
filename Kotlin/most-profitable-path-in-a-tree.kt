package mostprofitablepathinatree
// Time:  O(n)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun mostProfitablePath(edges: Array<IntArray>, bob: Int, amount: IntArray): Int {
        val adj = Array(edges.size + 1) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val lookup = Array(adj.size) { intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE) }
        val stack = ArrayDeque<IntArray>()
        stack.add(intArrayOf(1, 0, -1, 0))
        while (stack.isNotEmpty()) {
            val (step, u, p, ah) = stack.removeLast()
            if (step == 1) {
                stack.add(intArrayOf(2, u, p, ah))
                for (v in adj[u]) {
                    if (v != p) {
                        stack.add(intArrayOf(1, v, u, ah + 1))
                    }
                }
            } else {
                if (adj[u].size + (if (u == 0) 1 else 0) == 1) {
                    lookup[u][0] = 0
                }
                if (u == bob) {
                    lookup[u][1] = 0
                }
                for (v in adj[u]) {
                    if (v != p) {
                        lookup[u][0] = maxOf(lookup[u][0], lookup[v][0])
                        lookup[u][1] = minOf(lookup[u][1], lookup[v][1])
                    }
                }
                if (ah == lookup[u][1]) {
                    lookup[u][0] += amount[u] / 2
                } else if (ah < lookup[u][1]) {
                    lookup[u][0] += amount[u]
                }
                if (lookup[u][1] != Int.MAX_VALUE) {
                    lookup[u][1]++
                }
            }
        }
        return lookup[0][0]
    }
}
