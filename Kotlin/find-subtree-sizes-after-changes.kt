package findsubtreesizesafterchanges

// Time:  O(n)
// Space: O(n)

// iterative dfs, hash table
class Solution {
    fun findSubtreeSizes(parent: IntArray, s: String): IntArray {
        val adj = Array(parent.size) { mutableListOf<Int>() }
        for (v in parent.indices) {
            if (parent[v] != -1) {
                adj[parent[v]].add(v)
            }
        }

        val lookup = Array(26) { mutableListOf<Int>() }
        val result = IntArray(parent.size) { 1 }
        val stk = mutableListOf(intArrayOf(1, 0))
        while (stk.isNotEmpty()) {
            val top = stk.removeAt(stk.size - 1)
            val step = top[0]
            val u = top[1]
            if (step == 1) {
                lookup[s[u] - 'a'].add(u)
                stk.add(intArrayOf(2, u))
                for (v in adj[u]) {
                    stk.add(intArrayOf(1, v))
                }
            } else if (step == 2) {
                for (v in adj[u]) {
                    val i = if (lookup[s[v] - 'a'].isNotEmpty()) lookup[s[v] - 'a'].last() else u
                    result[i] += result[v]
                }
                lookup[s[u] - 'a'].removeAt(lookup[s[u] - 'a'].size - 1)
            }
        }
        return result
    }
}
