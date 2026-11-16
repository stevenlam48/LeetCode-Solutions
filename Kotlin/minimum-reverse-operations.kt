package minimumreverseoperations

// Time:  O(n * alpha(n)) = O(n)
// Space: O(n)

class Solution {
    fun minReverseOperations(n: Int, p: Int, banned: IntArray, k: Int): IntArray {
        val lookup = BooleanArray(n)
        for (i in banned) {
            lookup[i] = true
        }
        var d = 0
        val result = IntArray(n) { -1 }
        result[p] = d++
        val uf = UnionFind(n + 2)
        uf.unionSet(p, p + 2)
        var q = mutableListOf(p)
        while (q.isNotEmpty()) {
            val newQ = mutableListOf<Int>()
            for (start in q) {
                val left = 2 * maxOf(start - (k - 1), 0) + (k - 1) - start
                val right = 2 * minOf(start + (k - 1), n - 1) - (k - 1) - start
                var pos = uf.rightSet(left)
                while (pos <= right) {
                    if (!lookup[pos]) {
                        result[pos] = d
                        newQ.add(pos)
                    }
                    uf.unionSet(pos, pos + 2)
                    pos = uf.rightSet(pos)
                }
            }
            q = newQ
            ++d
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)
        private val right = IntArray(n) { it }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x0: Int, y0: Int): Boolean {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
                return false
            }
            if (rank[x] > rank[y]) {
                val tmp = x
                x = y
                y = tmp
            }
            set[x] = y
            if (rank[x] == rank[y]) {
                ++rank[y]
            }
            right[y] = maxOf(right[x], right[y])
            return true
        }

        fun rightSet(x: Int): Int = right[findSet(x)]
    }
}
