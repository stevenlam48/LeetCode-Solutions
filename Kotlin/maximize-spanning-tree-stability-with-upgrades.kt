package maximizespanningtreestabilitywithupgrades
// Time:  O(n + eloge)
// Space: O(n)

class Solution {
    fun maxStability(n: Int, edges: Array<IntArray>, k: Int): Int {
        val uf = UnionFind(n)
        var cnt = 0
        var result = Int.MAX_VALUE
        for (e in edges) {
            val u = e[0]
            val v = e[1]
            val s = e[2]
            val m = e[3]
            if (m == 0) {
                continue
            }
            if (!uf.unionSet(u, v)) {
                return -1
            }
            ++cnt
            result = minOf(result, s)
        }
        edges.sortWith(Comparator { a, b -> b[2].compareTo(a[2]) })
        for (e in edges) {
            val u = e[0]
            val v = e[1]
            val s = e[2]
            val m = e[3]
            if (m != 0) {
                continue
            }
            if (!uf.unionSet(u, v)) {
                continue
            }
            ++cnt
            if (cnt == (n - 1) - k) {
                result = minOf(result, s)
            } else if (cnt == n - 1) {
                result = minOf(result, 2 * s)
            }
        }
        return if (cnt == n - 1) result else -1
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)

        fun findSet(x: Int): Int {
            var root = x
            val stack = mutableListOf<Int>()
            while (set[root] != root) {
                stack.add(root)
                root = set[root]
            }
            while (stack.isNotEmpty()) {
                val y = stack.removeLast()
                set[y] = root
            }
            return root
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
            }
            set[rootX] = rootY
            if (rank[rootX] == rank[rootY]) {
                ++rank[rootY]
            }
            return true
        }
    }
}
