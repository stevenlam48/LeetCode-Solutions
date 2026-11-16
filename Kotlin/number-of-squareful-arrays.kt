package numberofsquarefularrays

// Time:  O(n!)
// Space: O(n^2)

class Solution {
    fun numSquarefulPerms(A: IntArray): Int {
        val count = HashMap<Int, Int>()
        for (a in A) {
            count[a] = (count[a] ?: 0) + 1
        }
        val candidate = HashMap<Int, MutableSet<Int>>()
        for (x in count.keys) {
            for (y in count.keys) {
                val s = kotlin.math.sqrt((x + y).toDouble()).toInt()
                if (s * s == x + y) {
                    candidate.getOrPut(x) { mutableSetOf() }.add(y)
                }
            }
        }

        var result = 0

        fun dfs(x: Int, left: Int) {
            count[x] = count[x]!! - 1
            if (left == 0) {
                ++result
            }
            candidate[x]?.let { cands ->
                for (y in cands) {
                    if (count[y]!! > 0) {
                        dfs(y, left - 1)
                    }
                }
            }
            count[x] = count[x]!! + 1
        }

        for (x in count.keys.toList()) {
            dfs(x, A.size - 1)
        }
        return result
    }
}
