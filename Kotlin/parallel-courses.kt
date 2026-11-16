package parallelcourses

// Time:  O(|V| + |E|)
// Space: O(|E|)

class Solution {
    fun minimumSemesters(N: Int, relations: Array<IntArray>): Int {
        val g = HashMap<Int, MutableList<Int>>()
        val inDegree = IntArray(N)
        for (r in relations) {
            g.getOrPut(r[0] - 1) { mutableListOf() }.add(r[1] - 1)
            inDegree[r[1] - 1]++
        }
        val q = ArrayDeque<Pair<Int, Int>>()
        for (i in 0 until N) {
            if (inDegree[i] == 0) {
                q.addLast(Pair(1, i))
            }
        }

        var result = 0
        var count = N
        while (q.isNotEmpty()) {
            val (level, u) = q.removeFirst()
            --count
            result = level
            for (v in g[u].orEmpty()) {
                --inDegree[v]
                if (inDegree[v] == 0) {
                    q.addLast(Pair(level + 1, v))
                }
            }
        }
        return if (count == 0) result else -1
    }
}
