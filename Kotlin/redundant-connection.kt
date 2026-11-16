package redundantconnection

// Time:  O(nlog*n) ~= O(n), n is the length of the positions
// Space: O(n)

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val unionFind = UnionFind(edges.size + 1)
        for (edge in edges) {
            if (!unionFind.unionSet(edge[0], edge[1])) {
                return edge
            }
        }
        return intArrayOf()
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            return true
        }
    }
}
