package countnumberofpossiblerootnodes

// Time:  O(n) 
// Space: O(h)

class Solution {
    fun rootCount(edges: Array<IntArray>, guesses: Array<IntArray>, k: Int): Int {
        val adj = HashMap<Int, MutableList<Int>>()
        for (e in edges) {
            adj.getOrPut(e[0]) { mutableListOf() }.add(e[1])
            adj.getOrPut(e[1]) { mutableListOf() }.add(e[0])
        }
        val lookup = HashSet<Long>()
        for (g in guesses) {
            lookup.add(key(g[0], g[1]))
        }

        var curr = 0
        val stk = mutableListOf(0 to -1)
        while (stk.isNotEmpty()) {
            val (u, p) = stk.removeAt(stk.lastIndex)
            if (key(p, u) in lookup) {
                ++curr
            }
            for (v in adj.getOrDefault(u, emptyList())) {
                if (v != p) {
                    stk.add(v to u)
                }
            }
        }

        var result = 0
        val stk2 = mutableListOf(Triple(0, -1, curr))
        while (stk2.isNotEmpty()) {
            val (u, p, previous) = stk2.removeAt(stk2.lastIndex)
            var current = previous
            if (key(p, u) in lookup) {
                --current
            }
            if (key(u, p) in lookup) {
                ++current
            }
            if (current >= k) {
                ++result
            }
            for (v in adj.getOrDefault(u, emptyList())) {
                if (v != p) {
                    stk2.add(Triple(v, u, current))
                }
            }
        }
        return result
    }

    private fun key(u: Int, v: Int): Long {
        return (u.toLong() shl 32) xor (v.toLong() and 0xffffffffL)
    }
}
