package countthenumberofcompletecomponents

// Time:  O(n)
// Space: O(n)

// bfs
class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val lookup = BooleanArray(n)
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }
        val bfs = { start: Int ->
            if (lookup[start]) {
                false
            } else {
                var vCnt = 0
                var eCnt = 0
                lookup[start] = true
                var q = mutableListOf(start)
                while (q.isNotEmpty()) {
                    val newQ = mutableListOf<Int>()
                    vCnt += q.size
                    for (u in q) {
                        eCnt += adj[u].size
                        for (v in adj[u]) {
                            if (lookup[v]) {
                                continue
                            }
                            lookup[v] = true
                            newQ.add(v)
                        }
                    }
                    q = newQ
                }
                vCnt * (vCnt - 1) == eCnt
            }
        }

        var result = 0
        for (u in 0 until n) {
            if (bfs(u)) {
                ++result
            }
        }
        return result
    }
}
