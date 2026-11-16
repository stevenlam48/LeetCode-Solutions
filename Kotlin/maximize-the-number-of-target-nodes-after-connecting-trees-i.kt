package maximizethenumberoftargetnodesafterconnectingtreesi

// Time:  O(nlogn + mlogm)
// Space: O(n + m)

class Solution {
    fun maxTargetNodes(edges1: Array<IntArray>, edges2: Array<IntArray>, k: Int): IntArray {
        fun centroidDecomposition(adj: Array<MutableList<Int>>, k: Int): IntArray {
            val result = IntArray(adj.size)
            val sizes = IntArray(adj.size)
            val lookup = BooleanArray(adj.size)
            val prefix = Array(adj.size) { mutableListOf<Int>() }
            var cnt = mutableListOf<Int>()
            var total = mutableListOf<Int>()
            var curr = mutableListOf<Int>()

            fun findSubtreeSize(u: Int, p: Int): Int {
                sizes[u] = 1
                for (v in adj[u]) {
                    if (v == p || lookup[v]) {
                        continue
                    }
                    sizes[u] += findSubtreeSize(v, u)
                }
                return sizes[u]
            }

            fun findCentroid(u0: Int, p: Int): Int {
                val n = sizes[u0]
                fun find(u: Int, parent: Int): Int {
                    for (v in adj[u]) {
                        if (v == parent || lookup[v]) {
                            continue
                        }
                        if (sizes[v] * 2 > n) {
                            return find(v, u)
                        }
                    }
                    return u
                }
                return find(u0, p)
            }

            fun count(u: Int, p: Int, d: Int) {
                if (d > k) {
                    return
                }
                if (d - 1 == cnt.size) {
                    cnt.add(0)
                }
                cnt[d - 1]++
                for (v in adj[u]) {
                    if (v == p || lookup[v]) {
                        continue
                    }
                    count(v, u, d + 1)
                }
            }

            fun update(u: Int, p: Int, d: Int) {
                if (d > k) {
                    return
                }
                result[u] += total[minOf(k - d, total.size - 1)] - curr[minOf(k - d, curr.size - 1)]
                for (v in adj[u]) {
                    if (v == p || lookup[v]) {
                        continue
                    }
                    update(v, u, d + 1)
                }
            }

            fun dfs(u0: Int) {
                findSubtreeSize(u0, -1)
                val u = findCentroid(u0, -1)
                lookup[u] = true
                var maxD = 0
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    cnt = mutableListOf()
                    count(v, u, 1)
                    prefix[v].add(0)
                    for (d in cnt.indices) {
                        prefix[v].add(prefix[v].last() + cnt[d])
                    }
                    maxD = maxOf(maxD, cnt.size)
                }
                total = MutableList(maxD + 1) { 1 }
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    for (d in total.indices) {
                        total[d] += prefix[v][minOf(d, prefix[v].size - 1)]
                    }
                }
                result[u] += total[minOf(k, total.size - 1)]
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    curr = prefix[v]
                    update(v, u, 1)
                }
                for (v in adj[u]) {
                    if (lookup[v]) {
                        continue
                    }
                    dfs(v)
                }
            }

            if (k >= 0) {
                dfs(0)
            }
            return result
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
        val mx = centroidDecomposition(adj2, k - 1).max()
        val adj1 = findAdj(edges1)
        val ret = centroidDecomposition(adj1, k)
        return IntArray(adj1.size) { mx + ret[it] }
    }
}
