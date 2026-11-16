package smalleststringwithswaps
// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun smallestStringWithSwaps(s: String, pairs: Array<IntArray>): String {
        val unionFind = UnionFind(s.length)
        for (pair in pairs) {
            unionFind.unionSet(pair[0], pair[1])
        }
        val components = HashMap<Int, MutableList<Char>>()
        for (i in s.indices) {
            components.getOrPut(unionFind.findSet(i)) { mutableListOf() }.add(s[i])
        }
        for (list in components.values) {
            list.sortDescending()
        }
        val result = s.toCharArray()
        for (i in s.indices) {
            val j = unionFind.findSet(i)
            result[i] = components[j]!!.removeLast()
        }
        return String(result)
    }

    private class UnionFind(n: Int) {
        private val set = IntArray(n) { it }

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
            return true
        }
    }
}
