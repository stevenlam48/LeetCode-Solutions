package courseschedule

// Time:  O(|V| + |E|)
// Space: O(|E|)

import java.util.ArrayDeque

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adj = HashMap<Int, MutableList<Int>>()
        val inDegree = HashMap<Int, Int>()
        for (p in prerequisites) {
            inDegree[p[0]] = inDegree.getOrDefault(p[0], 0) + 1
            adj.getOrPut(p[1]) { mutableListOf() }.add(p[0])
        }
        val q = ArrayDeque<Int>()
        for (i in 0 until numCourses) {
            if (!inDegree.containsKey(i)) {
                q.add(i)
            }
        }
        val result = mutableListOf<Int>()
        while (q.isNotEmpty()) {
            val node = q.removeFirst()
            result.add(node)
            for (i in adj[node].orEmpty()) {
                val degree = inDegree.getValue(i) - 1
                inDegree[i] = degree
                if (degree == 0) {
                    q.add(i)
                }
            }
        }
        return result.size == numCourses
    }
}
