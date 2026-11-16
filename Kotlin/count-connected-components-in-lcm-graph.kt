package countconnectedcomponentsinlcmgraph

// Time:  O(n + tlogt), t = threshold
// Space: O(t)

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
        var xRoot = findSet(x)
        var yRoot = findSet(y)
        if (xRoot == yRoot) {
            return false
        }
        if (rank[xRoot] > rank[yRoot]) {
            xRoot = yRoot.also { yRoot = xRoot }
        }
        set[xRoot] = yRoot
        if (rank[xRoot] == rank[yRoot]) {
            ++rank[yRoot]
        }
        return true
    }
}

class Solution {
    fun countComponents(nums: IntArray, threshold: Int): Int {
        val uf = UnionFind(threshold)
        val lookup = IntArray(threshold) { -1 }
        var result = nums.size
        for (x in nums) {
            if (x - 1 >= threshold) {
                continue
            }
            var i = x
            while (i <= threshold) {
                if (lookup[i - 1] == -1) {
                    lookup[i - 1] = x - 1
                    i += x
                    continue
                }
                if (uf.unionSet(lookup[i - 1], x - 1)) {
                    --result
                }
                if (i == x) {
                    break
                }
                i += x
            }
        }
        return result
    }
}
