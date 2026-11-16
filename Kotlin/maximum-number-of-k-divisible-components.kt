package maximumnumberofkdivisiblecomponents
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val cnt = IntArray(n)
        for (u in 0 until n) {
            cnt[u] = adj[u].size
        }
        var result = 0
        val dp = IntArray(values.size) { values[it] % k }
        var q = mutableListOf<Int>()
        for (u in 0 until n) {
            if (cnt[u] == 1) {
                q.add(u)
            }
        }
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (u in q) {
                if (dp[u] == 0) {
                    ++result
                }
                for (v in adj[u]) {
                    dp[v] = (dp[v] + dp[u]) % k
                    if (--cnt[v] == 1) {
                        newQ.add(v)
                    }
                }
            }
            q = newQ
        }
        return maxOf(result, 1)
    }
}
