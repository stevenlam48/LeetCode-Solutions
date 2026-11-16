package finishtimeoftasksii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun finishTime(n: Int, edges: Array<IntArray>, baseTime: IntArray): Long {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val dp = LongArray(n)

        val stk = ArrayDeque<Triple<Int, Int, Int>>()
        stk.addLast(Triple(1, 0, -1))
        while (stk.isNotEmpty()) {
            val (step, u, p) = stk.removeLast()
            if (step == 1) {
                stk.addLast(Triple(2, u, p))
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    stk.addLast(Triple(1, v, u))
                }
            } else if (step == 2) {
                var mx = Long.MIN_VALUE
                var mn = Long.MAX_VALUE
                for (v in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    mx = maxOf(mx, dp[v])
                    mn = minOf(mn, dp[v])
                }
                dp[u] = (if (mx != Long.MIN_VALUE) 2 * mx - mn else 0L) + baseTime[u]
            }
        }

        var result = Long.MAX_VALUE
        val stk2 = ArrayDeque<Triple<Int, Int, Long>>()
        stk2.addLast(Triple(0, -1, Long.MIN_VALUE))
        while (stk2.isNotEmpty()) {
            val (u, p, t) = stk2.removeLast()
            var mx1 = Long.MIN_VALUE
            var mx2 = Long.MIN_VALUE
            var mn1 = Long.MAX_VALUE
            var mn2 = Long.MAX_VALUE
            for (v in adj[u]) {
                val x = if (v != p) dp[v] else t
                if (x > mx1) {
                    mx2 = mx1
                    mx1 = x
                } else if (x > mx2) {
                    mx2 = x
                }
                if (x < mn1) {
                    mn2 = mn1
                    mn1 = x
                } else if (x < mn2) {
                    mn2 = x
                }
            }
            result = minOf(result, (if (mx1 != Long.MIN_VALUE) 2 * mx1 - mn1 else 0L) + baseTime[u])
            for (v in adj[u]) {
                if (v == p) {
                    continue
                }
                val mx = if (dp[v] != mx1) mx1 else mx2
                val mn = if (dp[v] != mn1) mn1 else mn2
                stk2.addLast(Triple(v, u, (if (mx != Long.MIN_VALUE) 2 * mx - mn else 0L) + baseTime[u]))
            }
        }
        return result
    }
}
