package satisfiabilityofequalityequations

// Time:  O(n)
// Space: O(1)

class Solution {
    fun equationsPossible(equations: List<String>): Boolean {
        val unionFind = UnionFind(26)
        for (eqn in equations) {
            val x = eqn[0] - 'a'
            val y = eqn[3] - 'a'
            if (eqn[1] == '=') {
                unionFind.unionSet(x, y)
            }
        }
        for (eqn in equations) {
            val x = eqn[0] - 'a'
            val y = eqn[3] - 'a'
            if (eqn[1] == '!' && unionFind.findSet(x) == unionFind.findSet(y)) {
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
