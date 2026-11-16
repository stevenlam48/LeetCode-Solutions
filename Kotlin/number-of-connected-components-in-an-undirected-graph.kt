package numberofconnectedcomponentsinanundirectedgraph

// Time:  O(nlog*n) ~= O(n), n is the length of the positions
// Space: O(n)

class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val unionFind = UnionFind(n)
        for (e in edges) {
            unionFind.unionSet(e[0], e[1])
        }
        return unionFind.length()
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var count = n

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int) {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot != yRoot) {
                set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
                --count
            }
        }

        fun length(): Int {
            return count
        }
    }
}
