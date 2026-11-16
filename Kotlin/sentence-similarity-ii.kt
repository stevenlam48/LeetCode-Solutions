package sentencesimilarityii

// Time:  O(n + p)
// Space: O(p)

class Solution {
    fun areSentencesSimilarTwo(words1: List<String>, words2: List<String>, pairs: List<List<String>>): Boolean {
        if (words1.size != words2.size) {
            return false
        }
        val lookup = HashMap<String, Int>()
        val unionFind = UnionFind(2 * pairs.size)
        for (pair in pairs) {
            if (pair[0] !in lookup) {
                lookup[pair[0]] = lookup.size
            }
            if (pair[1] !in lookup) {
                lookup[pair[1]] = lookup.size
            }
            unionFind.unionSet(lookup[pair[0]]!!, lookup[pair[1]]!!)
        }
        for (i in words1.indices) {
            if (words1[i] != words2[i] &&
                (!lookup.containsKey(words1[i]) || !lookup.containsKey(words2[i]) ||
                    unionFind.findSet(lookup[words1[i]]!!) != unionFind.findSet(lookup[words2[i]]!!))) {
                return false
            }
        }
        return true
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
