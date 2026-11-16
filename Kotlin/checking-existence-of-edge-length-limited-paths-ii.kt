package checkingexistenceofedgelengthlimitedpathsii

// Time:  ctor:  O(mlogm + m * α(n) + nlogn) ~= O(mlogm + nlogn)
//        query: O(α(n) + logn) ~= O(logn)
// Space: O(nlogn + m)

class DistanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>) {
    private val uf = UnionFind(n)
    private val treeInfos = TreeInfos(n)

    init {
        edgeList.sortWith(compareBy { it[2] })
        val adj = HashMap<Int, MutableList<Pair<Int, Int>>>()
        for (edge in edgeList) {
            if (!uf.unionSet(edge[0], edge[1])) {
                continue
            }
            adj.getOrPut(edge[0]) { mutableListOf() }.add(Pair(edge[1], edge[2]))
            adj.getOrPut(edge[1]) { mutableListOf() }.add(Pair(edge[0], edge[2]))
        }
        treeInfos.init(adj)
    }

    fun query(p: Int, q: Int, limit: Int): Boolean {
        if (uf.findSet(p) != uf.findSet(q)) {
            return false
        }
        return treeInfos.maxWeight(p, q) < limit
    }

    private class TreeInfos(n: Int) {
        private val l = IntArray(n)
        private val r = IntArray(n)
        private val p = Array(n) { mutableListOf<Int>() }
        private val w = Array(n) { mutableListOf<Int>() }
        private var c = -1

        fun init(adj: Map<Int, List<Pair<Int, Int>>>) {
            for (i in l.indices) {
                if (l[i] != 0) {
                    continue
                }
                floodFill(adj, i, -1, 0)
            }
        }

        fun isAncestor(a: Int, b: Int): Boolean {
            return l[a] <= l[b] && r[b] <= r[a]
        }

        fun maxWeight(a: Int, b: Int): Int {
            var result = 0
            if (!isAncestor(a, b)) {
                result = maxOf(result, binaryLift(a, b))
            }
            if (!isAncestor(b, a)) {
                result = maxOf(result, binaryLift(b, a))
            }
            return result
        }

        private fun binaryLift(a0: Int, b: Int): Int {
            var a = a0
            var weight = 0
            for (i in p[a].size - 1 downTo 0) {
                if (i < p[a].size && !isAncestor(p[a][i], b)) {
                    weight = maxOf(weight, w[a][i])
                    a = p[a][i]
                }
            }
            return maxOf(weight, w[a][0])
        }

        private fun floodFill(children: Map<Int, List<Pair<Int, Int>>>, curr: Int, parent: Int, weight: Int) {
            if (parent != -1) {
                w[curr].add(weight)
                p[curr].add(parent)
            }
            var i = 0
            while (i < p[curr].size) {
                if (i >= p[p[curr][i]].size) {
                    break
                }
                w[curr].add(maxOf(w[curr][i], w[p[curr][i]][i]))
                p[curr].add(p[p[curr][i]][i])
                ++i
            }
            l[curr] = ++c
            children[curr]?.let { childrenList ->
                for ((child, edgeWeight) in childrenList) {
                    if (child == parent) {
                        continue
                    }
                    floodFill(children, child, curr, edgeWeight)
                }
            }
            r[curr] = c
        }
    }

    private class UnionFind(n: Int) {
        private val set_ = IntArray(n) { it }
        private val rank_ = IntArray(n)
        private var count_ = n

        fun findSet(x: Int): Int {
            var x0 = x
            if (set_[x0] != x0) {
                set_[x0] = findSet(set_[x0])
            }
            return set_[x0]
        }

        fun unionSet(x: Int, y: Int): Boolean {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot == yRoot) {
                return false
            }
            if (rank_[xRoot] < rank_[yRoot]) {
                set_[xRoot] = yRoot
            } else if (rank_[xRoot] > rank_[yRoot]) {
                set_[yRoot] = xRoot
            } else {
                set_[yRoot] = xRoot
                ++rank_[xRoot]
            }
            --count_
            return true
        }
    }
}
