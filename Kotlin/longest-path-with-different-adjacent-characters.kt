package longestpathwithdifferentadjacentcharacters

// Time:  O(n)
// Space: O(w)

// tree, bfs, topological sort
class Solution {
    fun longestPath(parent: IntArray, s: String): Int {
        val n = s.length
        val adj = Array(n) { mutableListOf<Int>() }
        val inDegree = IntArray(n)
        for (i in 1 until parent.size) {
            adj[i].add(parent[i])
            ++inDegree[parent[i]]
        }
        var result = 1
        val top2 = HashMap<Int, IntArray>()
        var q = mutableListOf<IntArray>()
        for (i in 0 until n) {
            if (inDegree[i] == 0) {
                q.add(intArrayOf(i, 1))
            }
        }
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<IntArray>()
            for (pair in q) {
                val u = pair[0]
                val l = pair[1]
                for (v in adj[u]) {
                    val t = top2.getOrPut(v) { IntArray(2) }
                    if (s[v] != s[u]) {
                        if (l > t[0]) {
                            t[1] = t[0]
                            t[0] = l
                        } else if (l > t[1]) {
                            t[1] = l
                        }
                    }
                    if (--inDegree[v] == 0) {
                        newQ.add(intArrayOf(v, t[0] + 1))
                        result = maxOf(result, t[0] + t[1] + 1)
                        top2.remove(v)
                    }
                }
            }
            q = newQ
        }
        return result
    }
}
