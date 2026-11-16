package lexicographicallysmallestequivalentstring

// Time:  O(nlog*n) ~= O(n), n is the length of S
// Space: O(n)

class Solution {
    fun smallestEquivalentString(A: String, B: String, S: String): String {
        val unionFind = UnionFind(26)
        for (i in A.indices) {
            unionFind.unionSet(A[i] - 'a', B[i] - 'a')
        }
        val result = StringBuilder()
        for (i in S.indices) {
            val parent = unionFind.findSet(S[i] - 'a')
            result.append('a' + parent)
        }
        return result.toString()
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
                set[maxOf(xRoot, yRoot)] = minOf(xRoot, yRoot)
            }
        }
    }
}
