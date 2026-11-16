package maximumpointsactivatedwithoneaddition
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxActivated(points: Array<IntArray>): Int {
        val uf = UnionFind(points.size)
        val lookup = Array(2) { hashMapOf<Int, Int>() }
        for (i in points.indices) {
            for (j in lookup.indices) {
                val coordinate = points[i][j]
                if (lookup[j].containsKey(coordinate)) {
                    uf.unionSet(i, lookup[j][coordinate]!!)
                } else {
                    lookup[j][coordinate] = i
                }
            }
        }
        val top = LongArray(minOf(2, points.size))
        for (i in points.indices) {
            if (uf.findSet(i) != i) {
                continue
            }
            var size = uf.total(i)
            for (j in top.indices) {
                if (size > top[j]) {
                    val temp = top[j]
                    top[j] = size
                    size = temp
                }
            }
        }
        return top.sum().toInt() + 1
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val size = LongArray(n) { 1 }

        fun findSet(x: Int): Int {
            var current = x
            val stack = ArrayDeque<Int>()
            while (set[current] != current) {
                stack.addLast(current)
                current = set[current]
            }
            while (stack.isNotEmpty()) {
                set[stack.removeLast()] = current
            }
            return current
        }

        fun unionSet(x: Int, y: Int): Boolean {
            var rootX = findSet(x)
            var rootY = findSet(y)
            if (rootX == rootY) {
                return false
            }
            if (rank[rootX] > rank[rootY]) {
                val temp = rootX
                rootX = rootY
                rootY = temp
            } else if (rank[rootX] == rank[rootY]) {
                ++rank[rootY]
            }
            set[rootX] = rootY
            size[rootY] += size[rootX]
            return true
        }

        fun total(x: Int): Long {
            return size[findSet(x)]
        }
    }
}
