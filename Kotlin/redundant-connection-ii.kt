package redundantconnectionii
// Time:  O(nlog*n) ~= O(n), n is the length of the positions
// Space: O(n)

class Solution {
    fun findRedundantDirectedConnection(edges: Array<IntArray>): IntArray {
        var cand1 = intArrayOf()
        var cand2 = intArrayOf()
        val parent = HashMap<Int, Int>()
        for (edge in edges) {
            if (!parent.containsKey(edge[1])) {
                parent[edge[1]] = edge[0]
            } else {
                cand1 = intArrayOf(parent[edge[1]]!!, edge[1])
                cand2 = edge
            }
        }

        val unionFind = UnionFind(edges.size + 1)
        for (edge in edges) {
            if (edge.contentEquals(cand2)) {
                continue
            }
            if (!unionFind.unionSet(edge[0], edge[1])) {
                return if (cand2.isEmpty()) edge else cand1
            }
        }
        return cand2
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
