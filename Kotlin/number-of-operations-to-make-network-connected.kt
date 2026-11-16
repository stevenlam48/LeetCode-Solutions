package numberofoperationstomakenetworkconnected

// Time:  O(|E| + |V|)
// Space: O(|V|)

class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) {
            return -1
        }
        val unionFind = UnionFind(n)
        for (connection in connections) {
            unionFind.unionSet(connection[0], connection[1])
        }
        return unionFind.size() - 1
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var size = n

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
            size--
            return true
        }

        fun size(): Int = size
    }
}
