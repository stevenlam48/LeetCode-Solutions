package connectingcitieswithminimumcost
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minimumCost(N: Int, connections: Array<IntArray>): Int {
        connections.sortWith(compareBy { it[2] })
        val unionFind = UnionFind(N)
        var result = 0
        for (c in connections) {
            if (unionFind.unionSet(c[0] - 1, c[1] - 1)) {
                result += c[2]
            }
        }
        return if (unionFind.size() == 1) result else -1
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

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            --count
            return true
        }

        fun size(): Int = count
    }
}
