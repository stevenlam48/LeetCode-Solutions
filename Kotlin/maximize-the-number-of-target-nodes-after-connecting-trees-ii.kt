package maximizethenumberoftargetnodesafterconnectingtreesii

// Time:  O(n + m)
// Space: O(n + m)

class Solution {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>): IntArray {
        fun bfs(adj: Array<MutableList<Int>>): IntArray {
            val lookup = IntArray(adj.size) { -1 }
            var q = mutableListOf(0)
            var parity = 0
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    for (v in adj[u]) {
                        if (lookup[v] != -1) {
                            continue
                        }
                        lookup[v] = parity xor 1
                        newQ.add(v)
                    }
                }
                q = newQ
                parity = parity xor 1
            }
            val cnt = lookup.sum()
            return IntArray(adj.size) { u -> if (lookup[u] != 0) cnt else adj.size - cnt }
        }

        fun findAdj(edges: Array<IntArray>): Array<MutableList<Int>> {
            val adj = Array(edges.size + 1) { mutableListOf<Int>() }
            for (e in edges) {
                adj[e[0]].add(e[1])
                adj[e[1]].add(e[0])
            }
            return adj
        }

        val adj2 = findAdj(edges2)
        val mx = bfs(adj2).max()
        val adj1 = findAdj(edges1)
        val ret = bfs(adj1)
        return IntArray(adj1.size) { mx + ret[it] }
    }
}
