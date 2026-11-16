package countsubtreeswithmaxdistancebetweencities
// Time:  O(n^6)
// Space: O(n^3)

class Solution {
    fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
        val adj = Array(n) { mutableListOf<Int>() }
        for (edge in edges) {
            val u = edge[0] - 1
            val v = edge[1] - 1
            adj[u].add(v)
            adj[v].add(u)
        }
        val lookup = IntArray(n)
        val result = IntArray(n - 1)
        for (i in 0 until n) {
            val dp = Array(n) { Array(n) { IntArray(n) } }
            val count = IntArray(n) { 1 }
            dfs(n, adj, i, -1, lookup, count, dp)
            lookup[i] = 1
            for (d in 1 until n) {
                for (maxD in d until minOf(2 * d + 1, n)) {
                    result[maxD - 1] += dp[i][d][maxD]
                }
            }
        }
        return result
    }

    private fun dfs(
        n: Int,
        adj: Array<MutableList<Int>>,
        curr: Int,
        parent: Int,
        lookup: IntArray,
        count: IntArray,
        dp: Array<Array<IntArray>>
    ) {
        for (child in adj[curr]) {
            if (child == parent || lookup[child] != 0) {
                continue
            }
            dfs(n, adj, child, curr, lookup, count, dp)
        }
        dp[curr][0][0] = 1
        for (child in adj[curr]) {
            if (child == parent || lookup[child] != 0) {
                continue
            }
            val newDpCurr = dp[curr].map { it.copyOf() }.toTypedArray()
            for (currD in 0 until count[curr]) {
                for (currMaxD in currD until minOf(2 * currD + 1, count[curr])) {
                    if (dp[curr][currD][currMaxD] == 0) {
                        continue
                    }
                    for (childD in 0 until count[child]) {
                        for (childMaxD in childD until minOf(2 * childD + 1, count[child])) {
                            val maxD = maxOf(currMaxD, childMaxD, currD + childD + 1)
                            newDpCurr[maxOf(currD, childD + 1)][maxD] +=
                                dp[curr][currD][currMaxD] * dp[child][childD][childMaxD]
                        }
                    }
                }
            }
            count[curr] += count[child]
            dp[curr] = newDpCurr
        }
    }
}
