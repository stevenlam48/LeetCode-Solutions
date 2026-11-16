package numberofgoodpaths

// Time:  O(nlogn)
// Space: O(n)

// tree, sort, union find
class Solution {
    fun numberOfGoodPaths(vals: IntArray, edges: Array<IntArray>): Int {
        edges.sortWith(compareBy { maxOf(vals[it[0]], vals[it[1]]) })
        var result = vals.size
        val uf = UnionFind(vals)
        for (e in edges) {
            result += uf.unionSet(e[0], e[1], maxOf(vals[e[0]], vals[e[1]]))
        }
        return result
    }

    private class UnionFind(nums: IntArray) {
        private val set = IntArray(nums.size) { it }
        private val rank = IntArray(nums.size)
        private val cnt = Array(nums.size) { HashMap<Int, Int>() }

        init {
            for (i in nums.indices) {
                cnt[i][nums[i]] = (cnt[i][nums[i]] ?: 0) + 1
            }
        }

        fun findSet(x0: Int): Int {
            var x = x0
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x0: Int, y0: Int, v: Int): Int {
            var x = findSet(x0)
            var y = findSet(y0)
            if (x == y) {
                return 0
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
            val cx = cnt[x][v] ?: 0
            val cy = cnt[y][v] ?: 0
            cnt[y] = hashMapOf(v to cx + cy)
            return cx * cy
        }
    }
}
