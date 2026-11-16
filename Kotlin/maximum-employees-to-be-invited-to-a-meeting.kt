package maximumemployeestobeinvitedtoameeting

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumInvitations(favorite: IntArray): Int {
        val invAdj = Array(favorite.size) { mutableListOf<Int>() }
        for (u in favorite.indices) {
            invAdj[favorite[u]].add(u)
        }
        var result = 0
        var cycle2s = 0
        for ((u, l) in findCycles(favorite)) {
            if (l > 2) {
                result = maxOf(result, l)
                continue
            }
            cycle2s += bfs(invAdj, u, favorite[u]) + bfs(invAdj, favorite[u], u)
        }
        return maxOf(result, cycle2s)
    }

    private fun findCycles(adj: IntArray): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()
        val lookup = BooleanArray(adj.size)
        for (i in adj.indices) {
            val cnt = HashMap<Int, Int>()
            var u = i
            while (!lookup[u]) {
                lookup[u] = true
                cnt[u] = cnt.size
                u = adj[u]
            }
            if (cnt.containsKey(u)) {
                result.add(u to cnt.size - cnt[u]!!)
            }
        }
        return result
    }

    private fun bfs(adj: Array<MutableList<Int>>, u: Int, exclude: Int): Int {
        var result = 0
        var q = listOf(u)
        while (q.isNotEmpty()) {
            ++result
            val newQ = mutableListOf<Int>()
            for (u in q) {
                for (v in adj[u]) {
                    if (v == exclude) {
                        continue
                    }
                    newQ.add(v)
                }
            }
            q = newQ
        }
        return result
    }
}
