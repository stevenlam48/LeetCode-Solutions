package minimumthresholdpathwithlimitedheavyedges

import java.util.ArrayDeque

// Time:  O((n + e) * loge)
// Space: O(n + e)

class Solution {
    fun minimumThreshold(n: Int, edges: Array<IntArray>, source: Int, target: Int, k: Int): Int {
        val adj = Array(n) { mutableListOf<Pair<Int, Int>>() }
        val weights = mutableListOf(0)
        for (e in edges) {
            adj[e[0]].add(Pair(e[1], e[2]))
            adj[e[1]].add(Pair(e[0], e[2]))
            weights.add(e[2])
        }
        val sortedWeights = weights.distinct().sorted()

        fun check(t: Int): Boolean {
            val lookup = BooleanArray(n)
            val dq = ArrayDeque<IntArray>()
            dq.addFirst(intArrayOf(source, 0))
            while (dq.isNotEmpty()) {
                val cur = dq.pollFirst()
                val u = cur[0]
                val d = cur[1]
                if (lookup[u]) {
                    continue
                }
                lookup[u] = true
                if (u == target) {
                    return d <= k
                }
                for ((v, w) in adj[u]) {
                    if (w <= t) {
                        dq.addFirst(intArrayOf(v, d))
                    } else {
                        dq.addLast(intArrayOf(v, d + 1))
                    }
                }
            }
            return false
        }

        var left = 0
        var right = sortedWeights.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (check(sortedWeights[mid])) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return if (left < sortedWeights.size) sortedWeights[left] else -1
    }
}
