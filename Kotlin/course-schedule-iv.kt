package coursescheduleiv

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        val reachable = floydWarshall(n, prerequisites)
        return BooleanArray(queries.size) { i ->
            queries[i][0] * n + queries[i][1] in reachable
        }
    }

    private fun floydWarshall(n: Int, graph: Array<IntArray>): HashSet<Int> {
        val reachable = HashSet<Int>()
        for (connected in graph) {
            reachable.add(connected[0] * n + connected[1])
        }
        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    if (i * n + j !in reachable && i * n + k in reachable && k * n + j in reachable) {
                        reachable.add(i * n + j)
                    }
                }
            }
        }
        return reachable
    }
}
