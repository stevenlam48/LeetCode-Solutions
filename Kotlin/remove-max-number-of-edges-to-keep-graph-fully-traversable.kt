package removemaxnumberofedgestokeepgraphfullytraversable

// Time:  O(n + m * α(n)) ~= O(n + m)
// Space: O(n)
class Solution {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        var result = 0
        val unionFindA = UnionFind(n)
        val unionFindB = UnionFind(n)
        for (edge in edges) {
            val t = edge[0]
            val i = edge[1]
            val j = edge[2]
            if (t != 3) {
                continue
            }
            val a = unionFindA.unionSet(i - 1, j - 1)
            val b = unionFindB.unionSet(i - 1, j - 1)
            if (!a && !b) {
                ++result
            }
        }
        for (edge in edges) {
            val t = edge[0]
            val i = edge[1]
            val j = edge[2]
            if (t == 1) {
                if (!unionFindA.unionSet(i - 1, j - 1)) {
                    ++result
                }
            } else if (t == 2) {
                if (!unionFindB.unionSet(i - 1, j - 1)) {
                    ++result
                }
            }
        }
        return if (unionFindA.size() == 1 && unionFindB.size() == 1) result else -1
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var size = n

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x]) // Path compression.
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            set[maxOf(xRoot, yRoot)] = minOf(xRoot, yRoot)
            --size
            return true
        }

        fun size(): Int = size
    }
}
