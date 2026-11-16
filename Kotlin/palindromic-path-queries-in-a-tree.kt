package palindromicpathqueriesinatree

// Time:  O((n + q) * logn)
// Space: O(n)

// hld, lca, fenwick tree
class Solution {
    fun palindromePath(n: Int, edges: Array<IntArray>, s: String, queries: List<String>): List<Boolean> {
        val adj = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            adj[e[0]].add(e[1])
            adj[e[1]].add(e[0])
        }

        val chars = s.toCharArray()
        val parent = IntArray(n) { -1 }
        val depth = IntArray(n)
        val sz = IntArray(n) { 1 }
        val heavy = IntArray(n) { -1 }
        val head = IntArray(n) { it }
        val prefix = IntArray(n)
        val left = IntArray(n) { -1 }
        val right = IntArray(n) { -1 }

        run {
            val stepStk = ArrayList<Int>()
            val nodeStk = ArrayList<Int>()
            val parStk = ArrayList<Int>()
            stepStk.add(1)
            nodeStk.add(1)
            parStk.add(-1)
            while (stepStk.isNotEmpty()) {
                val step = stepStk.removeAt(stepStk.size - 1)
                val u = nodeStk.removeAt(nodeStk.size - 1)
                val p = parStk.removeAt(parStk.size - 1)
                if (step == 1) {
                    prefix[u] = (if (p != -1) prefix[p] else 0) xor (1 shl (chars[u] - 'a'))
                    parent[u] = p
                    depth[u] = if (p == -1) 0 else depth[p] + 1
                    stepStk.add(2)
                    nodeStk.add(u)
                    parStk.add(p)
                    for (v in adj[u]) {
                        if (v == p) {
                            continue
                        }
                        stepStk.add(1)
                        nodeStk.add(v)
                        parStk.add(u)
                    }
                } else {
                    for (v in adj[u]) {
                        if (v == parent[u]) {
                            continue
                        }
                        sz[u] += sz[v]
                        if (heavy[u] == -1 || sz[v] > sz[heavy[u]]) {
                            heavy[u] = v
                        }
                    }
                }
            }
        }

        run {
            var idx = -1
            val stepStk = ArrayList<Int>()
            val nodeStk = ArrayList<Int>()
            val headStk = ArrayList<Int>()
            stepStk.add(1)
            nodeStk.add(1)
            headStk.add(0)
            while (stepStk.isNotEmpty()) {
                val step = stepStk.removeAt(stepStk.size - 1)
                val u = nodeStk.removeAt(nodeStk.size - 1)
                val h = headStk.removeAt(headStk.size - 1)
                if (step == 1) {
                    head[u] = h
                    idx++
                    left[u] = idx
                    stepStk.add(2)
                    nodeStk.add(u)
                    headStk.add(h)
                    for (v in adj[u]) {
                        if (v == parent[u] || v == heavy[u]) {
                            continue
                        }
                        stepStk.add(1)
                        nodeStk.add(v)
                        headStk.add(v)
                    }
                    if (heavy[u] != -1) {
                        stepStk.add(1)
                        nodeStk.add(heavy[u])
                        headStk.add(h)
                    }
                } else {
                    right[u] = idx
                }
            }
        }

        fun lca(u0: Int, v0: Int): Int {
            var u = u0
            var v = v0
            while (head[u] != head[v]) {
                if (depth[head[u]] < depth[head[v]]) {
                    val tmp = u
                    u = v
                    v = tmp
                }
                u = parent[head[u]]
            }
            return if (depth[u] < depth[v]) u else v
        }

        val bit = BIT(n + 1)
        val result = ArrayList<Boolean>()
        for (q in queries) {
            val parts = q.split(" ")
            val op = parts[0]
            val u = parts[1].toInt()
            if (op == "update") {
                val c = parts[2][0]
                val diff = (1 shl (chars[u] - 'a')) xor (1 shl (c - 'a'))
                if (diff == 0) {
                    continue
                }
                chars[u] = c
                bit.add(left[u], diff)
                bit.add(right[u] + 1, diff)
            } else {
                val v = parts[2].toInt()
                val l = lca(u, v)
                val mask = (prefix[u] xor bit.query(left[u])) xor
                    (prefix[v] xor bit.query(left[v])) xor
                    (1 shl (chars[l] - 'a'))
                result.add((mask and (mask - 1)) == 0)
            }
        }
        return result
    }

    private class BIT(n: Int) {
        private val bit = IntArray(n + 1)

        fun add(i0: Int, value: Int) {
            var i = i0 + 1
            while (i < bit.size) {
                bit[i] = bit[i] xor value
                i += i and -i
            }
        }

        fun query(i0: Int): Int {
            var i = i0 + 1
            var total = 0
            while (i > 0) {
                total = total xor bit[i]
                i -= i and -i
            }
            return total
        }
    }
}
