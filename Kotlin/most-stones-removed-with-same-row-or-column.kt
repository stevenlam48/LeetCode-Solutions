package moststonesremovedwithsameroworcolumn
// Time:  O(n)
// Space: O(n)

class Solution {
    fun removeStones(stones: Array<IntArray>): Int {
        val unionFind = UnionFind(2 * MAX_ROW)
        for (stone in stones) {
            unionFind.unionSet(stone[0], stone[1] + MAX_ROW)
        }
        val components = HashSet<Int>()
        for (stone in stones) {
            components.add(unionFind.findSet(stone[0]))
        }
        return stones.size - components.size
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }

        fun findSet(x: Int): Int {
            if (set[x] != x) {
                set[x] = findSet(set[x])
            }
            return set[x]
        }

        fun unionSet(x: Int, y: Int) {
            val xRoot = findSet(x)
            val yRoot = findSet(y)
            if (xRoot != yRoot) {
                set[minOf(xRoot, yRoot)] = maxOf(xRoot, yRoot)
            }
        }
    }

    companion object {
        private const val MAX_ROW = 10000
    }
}
