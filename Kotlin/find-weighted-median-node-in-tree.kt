package findweightedmediannodeintree

// Time:  O(n + qlogh)
// Space: O(n + q)

import java.util.ArrayDeque

private class UnionFind(n: Int) {
    private val set = IntArray(n) { it }
    private val rank = IntArray(n)

    fun findSet(x: Int): Int {
        var root = x
        val stack = mutableListOf<Int>()
        while (set[root] != root) {
            stack.add(root)
            root = set[root]
        }
        for (i in stack.indices.reversed()) {
            set[stack[i]] = root
        }
        return root
    }

    fun unionSet(x: Int, y: Int): Boolean {
        var a = findSet(x)
        var b = findSet(y)
        if (a == b) {
            return false
        }
        if (rank[a] > rank[b]) {
            val tmp = a
            a = b
            b = tmp
        }
        set[a] = b
        if (rank[a] == rank[b]) {
            ++rank[b]
        }
        return true
    }
}

private fun binarySearch(leftBound: Int, rightBound: Int, check: (Int) -> Boolean): Int {
    var left = leftBound
    var right = rightBound
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (check(mid)) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return left
}

class Solution {
    fun findMedian(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val adj = Array(edges.size + 1) { mutableListOf<Pair<Int, Int>>() }
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2]))
            adj[e[1]].add(Pair(e[0], e[2]))
        }
        val lookup = BooleanArray(adj.size)
        val lookup2 = Array(adj.size) { mutableListOf<Int>() }
        for (i in queries.indices) {
            for (x in queries[i]) {
                lookup2[x].add(i)
            }
        }
        val uf = UnionFind(adj.size)
        val ancestor = IntArray(adj.size) { it }
        val dist = LongArray(adj.size)
        val depth = IntArray(adj.size)
        val lca = IntArray(queries.size)
        val result = LongArray(queries.size)
        val stack = ArrayDeque<IntArray>()
        stack.addLast(intArrayOf(1, 0, -1, -1))
        while (stack.isNotEmpty()) {
            val frame = stack.removeLast()
            val step = frame[0]
            val u = frame[1]
            val p = frame[2]
            val i = frame[3]
            if (step == 1) {
                for (queryIndex in lookup2[u]) {
                    if (queries[queryIndex][0] == queries[queryIndex][1]) {
                        lca[queryIndex] = u
                        continue
                    }
                    result[queryIndex] += dist[u]
                    for (x in queries[queryIndex]) {
                        if (lookup[x]) {
                            lca[queryIndex] = ancestor[uf.findSet(x)]
                            result[queryIndex] -= 2 * dist[lca[queryIndex]]
                        }
                    }
                }
                lookup[u] = true
                stack.addLast(intArrayOf(2, u, -1, 0))
            } else if (step == 2) {
                if (i == adj[u].size) {
                    continue
                }
                val (v, w) = adj[u][i]
                stack.addLast(intArrayOf(2, u, -1, i + 1))
                if (lookup[v]) {
                    continue
                }
                dist[v] = dist[u] + w
                depth[v] = depth[u] + 1
                stack.addLast(intArrayOf(3, v, u, -1))
                stack.addLast(intArrayOf(1, v, -1, -1))
            } else {
                uf.unionSet(u, p)
                ancestor[uf.findSet(p)] = p
            }
        }

        val lookup3 = Array(adj.size) { mutableListOf<Pair<Int, Int>>() }
        for (i in queries.indices) {
            val u = queries[i][0]
            val v = queries[i][1]
            if (2 * (dist[u] - dist[lca[i]]) >= result[i]) {
                lookup3[u].add(Pair(i, 0))
            } else {
                lookup3[v].add(Pair(i, 1))
            }
        }
        val result2 = IntArray(queries.size)
        val path = mutableListOf<Int>()
        val stack2 = ArrayDeque<IntArray>()
        stack2.addLast(intArrayOf(1, 0, -1))
        while (stack2.isNotEmpty()) {
            val frame = stack2.removeLast()
            val step = frame[0]
            val u = frame[1]
            val i = frame[2]
            if (step == 1) {
                path.add(u)
                for ((queryIndex, type) in lookup3[u]) {
                    val d = depth[u] - depth[lca[queryIndex]]
                    if (type == 0) {
                        val j = binarySearch(0, d) { x ->
                            2 * (dist[u] - dist[path[path.size - (x + 1)]]) >= result[queryIndex]
                        }
                        result2[queryIndex] = path[path.size - (j + 1)]
                    } else {
                        val leftDistance = dist[queries[queryIndex][0]] - dist[lca[queryIndex]]
                        val j = binarySearch(0, d - 1) { x ->
                            2 * (leftDistance + dist[path[path.size - ((d - 1) + 1) + x]] - dist[lca[queryIndex]]) >= result[queryIndex]
                        }
                        result2[queryIndex] = path[path.size - ((d - 1) + 1) + j]
                    }
                }
                stack2.addLast(intArrayOf(3, u, -1))
                stack2.addLast(intArrayOf(2, u, 0))
            } else if (step == 2) {
                if (i == adj[u].size) {
                    continue
                }
                val (v, _) = adj[u][i]
                stack2.addLast(intArrayOf(2, u, i + 1))
                if (path.size >= 2 && path[path.size - 2] == v) {
                    continue
                }
                stack2.addLast(intArrayOf(1, v, -1))
            } else {
                path.removeAt(path.lastIndex)
            }
        }
        return result2
    }
}
