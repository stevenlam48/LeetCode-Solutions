package buildamatrixwithconditions

// Time:  O(k^2 + r + c), r = len(rowConditions), c = len(colConditions)
// Space: O(k + r + c)

// topological sort
class Solution {
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        fun topologicalSort(conditions: Array<IntArray>): List<Int> {
            val adj = Array(k) { mutableListOf<Int>() }
            val inDegree = IntArray(k)
            for (c in conditions) {
                val u = c[0] - 1
                val v = c[1] - 1
                adj[u].add(v)
                ++inDegree[v]
            }
            val result = mutableListOf<Int>()
            var q = mutableListOf<Int>()
            for (u in 0 until k) {
                if (inDegree[u] == 0) {
                    q.add(u)
                }
            }
            while (q.isNotEmpty()) {
                val newQ = mutableListOf<Int>()
                for (u in q) {
                    result.add(u)
                    for (v in adj[u]) {
                        --inDegree[v]
                        if (inDegree[v] != 0) {
                            continue
                        }
                        newQ.add(v)
                    }
                }
                q = newQ
            }
            return result
        }

        val rowOrder = topologicalSort(rowConditions)
        if (rowOrder.size != k) {
            return emptyArray()
        }
        val colOrder = topologicalSort(colConditions)
        if (colOrder.size != k) {
            return emptyArray()
        }
        val rowIdx = IntArray(k)
        for (i in 0 until k) {
            rowIdx[rowOrder[i]] = i
        }
        val colIdx = IntArray(k)
        for (i in 0 until k) {
            colIdx[colOrder[i]] = i
        }
        val result = Array(k) { IntArray(k) }
        for (i in 0 until k) {
            result[rowIdx[i]][colIdx[i]] = i + 1
        }
        return result
    }
}
