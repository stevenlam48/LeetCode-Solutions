package themostsimilarpathinagraph

// Time:  O(n^2 * m), m is the length of targetPath
// Space: O(n * m)

class Solution {
    fun mostSimilar(n: Int, roads: Array<IntArray>, names: Array<String>, targetPath: Array<String>): IntArray {
        val adj = Array(n) { ArrayList<Int>() }
        for (road in roads) {
            adj[road[0]].add(road[1])
            adj[road[1]].add(road[0])
        }

        val m = targetPath.size
        val dp = Array(m + 1) { IntArray(n) }
        for (i in 1..m) {
            for (v in 0 until n) {
                dp[i][v] = m
                for (u in adj[v]) {
                    dp[i][v] = Math.min(dp[i][v], dp[i - 1][u])
                }
                if (names[v] != targetPath[i - 1]) {
                    dp[i][v] += 1
                }
            }
        }

        var best = 0
        for (v in 1 until n) {
            if (dp[m][v] < dp[m][best]) {
                best = v
            }
        }
        val path = ArrayList<Int>()
        path.add(best)
        for (i in m downTo 2) {
            for (u in adj[path.last()]) {
                if (dp[i - 1][u] + (if (names[path.last()] != targetPath[i - 1]) 1 else 0) == dp[i][path.last()]) {
                    path.add(u)
                    break
                }
            }
        }
        path.reverse()
        return path.toIntArray()
    }
}
