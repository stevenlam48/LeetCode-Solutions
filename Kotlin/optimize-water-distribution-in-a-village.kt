package optimizewaterdistributioninavillage

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minCostToSupplyWater(n: Int, wells: IntArray, pipes: Array<IntArray>): Int {
        val nodes = mutableListOf<Triple<Int, Int, Int>>()
        for (i in wells.indices) {
            nodes.add(Triple(wells[i], 0, i + 1))
        }
        for (pipe in pipes) {
            nodes.add(Triple(pipe[2], pipe[0], pipe[1]))
        }
        nodes.sortWith(compareBy({ it.first }, { it.second }, { it.third }))
        var result = 0
        val unionFind = UnionFind(n + 1)
        for ((c, x, y) in nodes) {
            if (!unionFind.unionSet(x, y)) {
                continue
            }
            result += c
            if (unionFind.count() == 1) {
                break
            }
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private var cnt = n

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
            --cnt
            return true
        }

        fun count(): Int = cnt
    }
}
