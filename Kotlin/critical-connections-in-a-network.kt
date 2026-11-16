package criticalconnectionsinanetwork

// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

class Solution {
    fun criticalConnections(n: Int, connections: Array<IntArray>): Array<IntArray> {
        val edges = Array(n) { mutableListOf<Int>() }
        val idx = intArrayOf(0)
        val lowlinks = IntArray(n)
        val lookup = BooleanArray(n)
        val result = mutableListOf<IntArray>()
        for (c in connections) {
            edges[c.first()].add(c.last())
            edges[c.last()].add(c.first())
        }
        dfs(edges, -1, 0, idx, lowlinks, lookup, result)
        return result.toTypedArray()
    }

    private fun dfs(
        edges: Array<MutableList<Int>>,
        parent: Int,
        u: Int,
        idx: IntArray,
        lowlinks: IntArray,
        lookup: BooleanArray,
        result: MutableList<IntArray>
    ) {
        if (lookup[u]) {
            return
        }
        lookup[u] = true
        val currIdx = idx[0]++
        lowlinks[u] = currIdx
        for (v in edges[u]) {
            if (v == parent) {
                continue
            }
            dfs(edges, u, v, idx, lowlinks, lookup, result)
            lowlinks[u] = minOf(lowlinks[u], lowlinks[v])
            if (lowlinks[v] > currIdx) {
                result.add(intArrayOf(u, v))
            }
        }
    }
}
