package dividenodesintothemaximumnumberofgroups

// Time:  O(n^2)
// Space: O(n)

// iterative dfs, bfs
class Solution {
    fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0] - 1].add(e[1] - 1)
            adj[e[1] - 1].add(e[0] - 1)
        }
        val lookup = IntArray(n) { -1 }

        fun iterDfs(u0: Int): List<Int> {
            val group = mutableListOf<Int>()
            val stk = mutableListOf(u0)
            lookup[u0] = 0
            while (stk.isNotEmpty()) {
                val u = stk.removeAt(stk.size - 1)
                group.add(u)
                for (v in adj[u]) {
                    if (lookup[v] != -1) {
                        if (lookup[v] == lookup[u]) {
                            return emptyList()
                        }
                        continue
                    }
                    lookup[v] = lookup[u] xor 1
                    stk.add(v)
                }
            }
            return group
        }

        fun bfs(u0: Int): Int {
            var result = 0
            val seen = BooleanArray(n)
            var q = mutableListOf(u0)
            seen[u0] = true
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    for (v in adj[u]) {
                        if (seen[v]) {
                            continue
                        }
                        seen[v] = true
                        newQ.add(v)
                    }
                }
                q = newQ
                ++result
            }
            return result
        }

        var result = 0
        for (u in 0 until n) {
            if (lookup[u] != -1) {
                continue
            }
            val group = iterDfs(u)
            if (group.isEmpty()) {
                return -1
            }
            var mx = 0
            for (v in group) {
                mx = maxOf(mx, bfs(v))
            }
            result += mx
        }
        return result
    }
}
