package maximumweightedkedgepath

// Time:  O(k * e * t)
// Space: O(n * t)

class Solution {
    fun maxWeight(n: Int, edges: Array<IntArray>, k: Int, t: Int): Int {
        val adj = Array(n + 1) { ArrayList<IntArray>() }
        for (e in edges) {
            adj[e[0]].add(intArrayOf(e[1], e[2]))
        }
        var dp = Array(n) { HashSet<Int>() }
        for (i in 0 until n) {
            dp[i].add(0)
        }
        repeat(k) {
            val newDp = Array(n) { HashSet<Int>() }
            for (i in 0 until n) {
                for (c in dp[i]) {
                    for (e in adj[i]) {
                        val nc = c + e[1]
                        if (nc < t) {
                            newDp[e[0]].add(nc)
                        }
                    }
                }
            }
            dp = newDp
        }
        var result = -1
        for (s in dp) {
            if (s.isNotEmpty()) {
                result = maxOf(result, s.max())
            }
        }
        return result
    }
}
