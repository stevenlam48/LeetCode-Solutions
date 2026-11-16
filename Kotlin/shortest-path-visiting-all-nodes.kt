package shortestpathvisitingallnodes

// Time:  O(n * 2^n)
// Space: O(n * 2^n)

class Solution {
    fun shortestPathLength(graph: Array<IntArray>): Int {
        val n = graph.size
        val inf = Int.MAX_VALUE
        val dp = Array(1 shl n) { IntArray(n) { inf } }
        val q = ArrayDeque<Pair<Int, Int>>()
        for (i in 0 until n) {
            dp[1 shl i][i] = 0
            q.addLast((1 shl i) to i)
        }
        while (q.isNotEmpty()) {
            val (state, node) = q.removeFirst()
            val steps = dp[state][node]
            for (nei in graph[node]) {
                val newState = state or (1 shl nei)
                if (dp[newState][nei] == inf) {
                    dp[newState][nei] = steps + 1
                    q.addLast(newState to nei)
                }
            }
        }
        return dp[(1 shl n) - 1].min()
    }
}
