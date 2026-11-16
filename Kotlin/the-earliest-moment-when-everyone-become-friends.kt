package theearliestmomentwheneveryonebecomefriends
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun earliestAcq(logs: Array<IntArray>, N: Int): Int {
        logs.sortWith(compareBy<IntArray> { it[0] }.thenBy { it[1] }.thenBy { it[2] })
        val unionFind = UnionFind(N)
        for (log in logs) {
            unionFind.unionSet(log[1], log[2])
            if (unionFind.count() == 1) {
                return log[0]
            }
        }
        return -1
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

        fun count(): Int = count
    }
}
