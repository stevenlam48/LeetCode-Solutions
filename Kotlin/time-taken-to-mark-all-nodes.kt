package timetakentomarkallnodes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun timeTaken(edges: Array<IntArray>): IntArray {
        val adjacency = Array(edges.size + 1) { mutableListOf<Int>() }
        for (edge in edges) {
            adjacency[edge[0]].add(edge[1])
            adjacency[edge[1]].add(edge[0])
        }
        val dp = Array(edges.size + 1) { Array(2) { Pair(0, -1) } }

        val parent = IntArray(adjacency.size) { -2 }
        parent[0] = -1
        val topologicalOrder = mutableListOf(0)
        var index = 0
        while (index < topologicalOrder.size) {
            val u = topologicalOrder[index++]
            for (v in adjacency[u]) {
                if (parent[v] != -2) {
                    continue
                }
                parent[v] = u
                topologicalOrder.add(v)
            }
        }
        for (u in topologicalOrder.asReversed()) {
            for (v in adjacency[u]) {
                if (v == parent[u]) {
                    continue
                }
                var current = Pair((if (v % 2 != 0) 1 else 2) + dp[v][0].first, v)
                for (i in dp[u].indices) {
                    if (compareValuesBy(current, dp[u][i], { it.first }, { it.second }) > 0) {
                        val temporary = current
                        current = dp[u][i]
                        dp[u][i] = temporary
                    }
                }
            }
        }

        val result = IntArray(edges.size + 1)
        var queue = listOf(Triple(0, -1, 0))
        while (queue.isNotEmpty()) {
            val nextQueue = mutableListOf<Triple<Int, Int, Int>>()
            for ((u, p, current) in queue) {
                result[u] = maxOf(dp[u][0].first, current)
                for (v in adjacency[u]) {
                    if (v == p) {
                        continue
                    }
                    val alternative = dp[u][if (dp[u][0].second == v) 1 else 0].first
                    nextQueue.add(Triple(v, u, (if (u % 2 != 0) 1 else 2) + maxOf(alternative, current)))
                }
            }
            queue = nextQueue
        }
        return result
    }
}
