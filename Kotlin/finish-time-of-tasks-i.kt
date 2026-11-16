package finishtimeoftasksi

// Time:  O(n)
// Space: O(n)

class Solution {
    fun finishTime(n: Int, edges: Array<IntArray>, baseTime: IntArray): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
        }
        val dp = LongArray(n)
        val stk = ArrayDeque<Pair<Int, Int>>()
        stk.addLast(Pair(1, 0))
        while (stk.isNotEmpty()) {
            val (step, u) = stk.removeLast()
            if (step == 1) {
                stk.addLast(Pair(2, u))
                for (v in adj[u]) {
                    stk.addLast(Pair(1, v))
                }
            } else if (step == 2) {
                var mx = Long.MIN_VALUE
                var mn = Long.MAX_VALUE
                for (v in adj[u]) {
                    mx = maxOf(mx, dp[v])
                    mn = minOf(mn, dp[v])
                }
                dp[u] = (if (mx != Long.MIN_VALUE) 2 * mx - mn else 0L) + baseTime[u]
            }
        }
        return dp[0]
    }
}
