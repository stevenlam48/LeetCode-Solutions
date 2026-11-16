package incrementalevenweightedcyclequeries

// Time:  O(n + e)
// Space: O(n)

// union find
class Solution {
    fun numberOfEdgesAdded(n: Int, edges: Array<IntArray>): Int {
        var result = 0
        val uf = UnionFind(n)
        for (e in edges) {
            if (uf.unionSet(e[0], e[1], e[2])) {
                ++result
            }
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set_ = IntArray(n) { it }
        private val rank_ = IntArray(n)
        private val parity_ = IntArray(n)  // added

        fun findSet(x0: Int): Int {
            var x = x0
            if (set_[x] != x) {
                val root = findSet(set_[x])
                parity_[x] = parity_[x] xor parity_[set_[x]]  // added
                set_[x] = root
            }
            return set_[x]
        }

        fun unionSet(x0: Int, y0: Int, w: Int): Boolean {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
                return parity_[x0] xor w xor parity_[y0] == 0  // modified
            }
            if (rank_[x] > rank_[y]) {
                val tmp = x
                x = y
                y = tmp
            } else if (rank_[x] == rank_[y]) {
                ++rank_[y]
            }
            set_[x] = y  // Union by rank.
            parity_[x] = parity_[x0] xor w xor parity_[y0]  // added
            return true
        }
    }
}
