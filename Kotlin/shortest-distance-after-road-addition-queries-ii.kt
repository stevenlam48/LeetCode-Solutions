package shortestdistanceafterroadadditionqueriesii

// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeSet

class Solution {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val result = IntArray(queries.size)
        val bst = TreeSet<Int>()
        for (i in 0 until n) {
            bst.add(i)
        }
        for (i in queries.indices) {
            val query = queries[i]
            while (true) {
                val current = bst.higher(query[0]) ?: break
                if (current >= query[1]) {
                    break
                }
                bst.remove(current)
            }
            result[i] = bst.size - 1
        }
        return result
    }
}
