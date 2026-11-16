package processrestrictedfriendrequests

// Time:  O(n * (alpha(n) + r)) = O(n * r)
// Space: O(n)

class Solution {
    fun friendRequests(n: Int, restrictions: Array<IntArray>, requests: Array<IntArray>): BooleanArray {
        val result = BooleanArray(requests.size)
        val uf = UnionFind(n)
        for (i in requests.indices) {
            val request = requests[i]
            val pu = uf.findSet(request[0])
            val pv = uf.findSet(request[1])
            var ok = true
            for (restriction in restrictions) {
                val px = uf.findSet(restriction[0])
                val py = uf.findSet(restriction[1])
                if ((px == pu && py == pv) || (px == pv && py == pu)) {
                    ok = false
                    break
                }
            }
            result[i] = ok
            if (ok) {
                uf.unionSet(request[0], request[1])
            }
        }
        return result
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }
        private val rank = IntArray(n)

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
            if (rank[xRoot] < rank[yRoot]) {
                set[xRoot] = yRoot
            } else if (rank[xRoot] > rank[yRoot]) {
                set[yRoot] = xRoot
            } else {
                set[yRoot] = xRoot
                ++rank[xRoot]
            }
            return true
        }
    }
}
