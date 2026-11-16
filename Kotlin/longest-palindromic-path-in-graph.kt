package longestpalindromicpathingraph

// Time:  O(n^4 * 2^n)
// Space: O(n + e)

// bitmasks, dp, freq table
class Solution {
    fun maxLen(n: Int, edges: Array<IntArray>, label: String): Int {
        if (edges.size == n * (n - 1) / 2) {
            val cnt = IntArray(26)
            for (c in label) {
                ++cnt[c - 'a']
            }
            var result = 0
            for (c in cnt) {
                result += (c / 2) * 2
                if (c % 2 == 1 && result % 2 == 0) {
                    ++result
                }
            }
            return result
        }
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val dp = Array(1 shl n) { Array(n) { BooleanArray(n) } }
        for (u in 0 until n) {
            dp[1 shl u][u][u] = true
        }
        for (e in edges) {
            if (label[e[0]] == label[e[1]]) {
                dp[(1 shl e[0]) or (1 shl e[1])][minOf(e[0], e[1])][maxOf(e[0], e[1])] = true
            }
        }
        var result = 0
        for (mask in 1 until (1 shl n)) {
            for (u in 0 until n) {
                for (v in u until n) {
                    if (!dp[mask][u][v]) {
                        continue
                    }
                    result = maxOf(result, Integer.bitCount(mask))
                    for (nu in adj[u]) {
                        if (mask and (1 shl nu) != 0) {
                            continue
                        }
                        for (nv in adj[v]) {
                            if (mask and (1 shl nv) != 0) {
                                continue
                            }
                            if (nu == nv) {
                                continue
                            }
                            if (label[nu] == label[nv]) {
                                dp[mask or (1 shl nu) or (1 shl nv)][minOf(nu, nv)][maxOf(nu, nv)] = true
                            }
                        }
                    }
                }
            }
        }
        return result
    }
}
