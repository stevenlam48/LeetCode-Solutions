package bestteamwithnoconflicts

// Time:  O(nloga)
// Space: O(n)

class Solution {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val players = ArrayList<Pair<Int, Int>>()
        for (i in scores.indices) {
            players.add(Pair(scores[i], ages[i]))
        }
        players.sortWith(compareBy({ it.first }, { it.second }))
        val sortedAges = ages.toSortedSet()
        val lookup = HashMap<Int, Int>()
        for (age in sortedAges) {
            lookup[age] = lookup.size
        }
        val segmentTree = SegmentTree(lookup.size)
        for ((score, age) in players) {
            val idx = lookup[age]!!
            segmentTree.update(idx, idx, segmentTree.query(0, idx) + score)
        }
        return segmentTree.query(0, lookup.size - 1)
    }

    private class SegmentTree(N: Int) {
        private var N_: Int = N
        private var H_: Int = 1
        private var tree_: IntArray = IntArray(2 * N)
        private var lazy_: IntArray = IntArray(N)

        init {
            while ((1 shl H_) < N) {
                ++H_
            }
        }

        fun update(L: Int, R: Int, h: Int) {
            var L = L + N_
            var R = R + N_
            val L0 = L
            val R0 = R
            while (L <= R) {
                if ((L and 1) == 1) {
                    apply(L++, h)
                }
                if ((R and 1) == 0) {
                    apply(R--, h)
                }
                L = L shr 1
                R = R shr 1
            }
            pull(L0)
            pull(R0)
        }

        fun query(L: Int, R: Int): Int {
            var L = L + N_
            var R = R + N_
            var result = 0
            push(L)
            push(R)
            while (L <= R) {
                if ((L and 1) == 1) {
                    result = kotlin.math.max(result, tree_[L++])
                }
                if ((R and 1) == 0) {
                    result = kotlin.math.max(result, tree_[R--])
                }
                L = L shr 1
                R = R shr 1
            }
            return result
        }

        private fun apply(x: Int, `val`: Int) {
            tree_[x] = kotlin.math.max(tree_[x], `val`)
            if (x < N_) {
                lazy_[x] = kotlin.math.max(lazy_[x], `val`)
            }
        }

        private fun pull(x: Int) {
            var x = x
            while (x > 1) {
                x = x shr 1
                tree_[x] = kotlin.math.max(tree_[x * 2], tree_[x * 2 + 1])
                tree_[x] = kotlin.math.max(tree_[x], lazy_[x])
            }
        }

        private fun push(x: Int) {
            var h = H_
            while (h > 0) {
                val y = x shr h
                if (lazy_[y] > 0) {
                    apply(y * 2, lazy_[y])
                    apply(y * 2 + 1, lazy_[y])
                    lazy_[y] = 0
                }
                --h
            }
        }
    }
}
