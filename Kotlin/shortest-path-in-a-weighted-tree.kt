package shortestpathinaweightedtree

// Time:  O(nlogn)
// Space: O(n)

private class BIT(n: Int) {
    private val bit = IntArray(n + 1)

    fun add(i: Int, value: Int) {
        var idx = i + 1
        while (idx < bit.size) {
            bit[idx] += value
            idx += idx and -idx
        }
    }

    fun query(i: Int): Int {
        var idx = i + 1
        var total = 0
        while (idx > 0) {
            total += bit[idx]
            idx -= idx and -idx
        }
        return total
    }
}

class Solution {
    fun treeQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val adj = Array(n) { ArrayList<Pair<Int, Int>>() }
        for (e in edges) {
            val u = e[0] - 1
            val v = e[1] - 1
            val w = e[2]
            adj[u].add(v to w)
            adj[v].add(u to w)
        }

        val l = IntArray(n)
        val r = IntArray(n)
        val dist = IntArray(n)
        val lookup = IntArray(n)
        var cnt = 0
        val stk = ArrayDeque<IntArray>()
        stk.addLast(intArrayOf(1, 0, -1, 0))
        while (stk.isNotEmpty()) {
            val e = stk.removeLast()
            val step = e[0]
            val u = e[1]
            val p = e[2]
            val d = e[3]
            if (step == 1) {
                l[u] = cnt++
                dist[u] = d
                stk.addLast(intArrayOf(2, u, -1, -1))
                for ((v, w) in adj[u]) {
                    if (v == p) {
                        continue
                    }
                    lookup[v] = w
                    stk.addLast(intArrayOf(1, v, u, d + w))
                }
            } else if (step == 2) {
                r[u] = cnt
            }
        }

        val bit = BIT(n)
        val result = ArrayList<Int>()
        for (q in queries) {
            if (q[0] == 1) {
                var u = q[1] - 1
                var v = q[2] - 1
                val w = q[3]
                if (l[u] > l[v]) {
                    val tmp = u
                    u = v
                    v = tmp
                }
                val diff = w - lookup[v]
                bit.add(l[v], diff)
                bit.add(r[v], -diff)
                lookup[v] = w
            } else {
                val x = q[1] - 1
                result.add(dist[x] + bit.query(l[x]))
            }
        }
        return result.toIntArray()
    }
}
