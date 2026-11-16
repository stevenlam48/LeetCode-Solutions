package maximumpartitionfactor
// Time:  O(n^2 * logn)
// Space: O(n^2)

import kotlin.math.abs

class Solution {
    fun maxPartitionFactor(points: Array<IntArray>): Int {
        fun distance(u: Int, v: Int): Int {
            return abs(points[u][0] - points[v][0]) + abs(points[u][1] - points[v][1])
        }

        val sortedDistances = mutableListOf<Edge>()
        for (u in points.indices) {
            for (v in u + 1 until points.size) {
                sortedDistances.add(Edge(distance(u, v), u, v))
            }
        }
        sortedDistances.sortWith(compareBy<Edge>({ it.distance }, { it.u }, { it.v }))
        val uf = UnionFind(points.size)
        for (edge in sortedDistances) {
            if (!uf.unionSet(edge.u, edge.v)) {
                return edge.distance
            }
        }
        return 0
    }

    private data class Edge(val distance: Int, val u: Int, val v: Int)

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val parity = IntArray(n)

        fun findSet(x: Int): Int {
            var current = x
            val stack = ArrayDeque<Int>()
            while (set[current] != current) {
                stack.addLast(current)
                current = set[current]
            }
            while (stack.isNotEmpty()) {
                val y = stack.removeLast()
                parity[y] = parity[y] xor parity[set[y]]
                set[y] = current
            }
            return current
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val ox = x
            val oy = y
            var rootX = findSet(x)
            var rootY = findSet(y)
            if (rootX == rootY) {
                return parity[ox] != parity[oy]
            }
            if (rank[rootX] > rank[rootY]) {
                val temp = rootX
                rootX = rootY
                rootY = temp
            }
            if (rank[rootX] == rank[rootY]) {
                ++rank[rootY]
            }
            set[rootX] = rootY
            parity[rootX] = parity[ox] xor parity[oy] xor 1
            return true
        }
    }
}
