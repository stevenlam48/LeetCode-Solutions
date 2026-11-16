package maximumstarsumofagraph

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxStarSum(vals: IntArray, edges: Array<IntArray>, k: Int): Int {
        val adj = Array(vals.size) { ArrayList<Int>() }
        for (e in edges) {
            if (vals[e[1]] > 0) {
                adj[e[0]].add(e[1])
            }
            if (vals[e[0]] > 0) {
                adj[e[1]].add(e[0])
            }
        }
        var result = Int.MIN_VALUE
        for (u in vals.indices) {
            adj[u].sortWith(compareByDescending { vals[it] })
            var sum = vals[u]
            val take = minOf(k, adj[u].size)
            for (t in 0 until take) {
                sum += vals[adj[u][t]]
            }
            result = maxOf(result, sum)
        }
        return result
    }
}
