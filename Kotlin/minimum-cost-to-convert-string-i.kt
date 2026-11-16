package minimumcosttoconvertstringi
// Time:  O(o + k * eloge + n), k = len(set(original)), e is the number of edges reachable from a given node u
// Space: O(o + k * v), v is the number of nodes reachable from a given node u

import java.util.PriorityQueue

class Solution {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        val inf = Int.MAX_VALUE
        val dist = HashMap<Int, HashMap<Int, Int>>()
        for (i in original.indices) {
            val u = original[i] - 'a'
            val v = changed[i] - 'a'
            val edges = dist.getOrPut(u) { HashMap() }
            edges[v] = minOf(edges[v] ?: inf, cost[i])
        }

        fun dijkstra(start: Int): HashMap<Int, Int> {
            val best = hashMapOf(start to 0)
            val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
            minHeap.add(0 to start)
            while (minHeap.isNotEmpty()) {
                val (curr, u) = minHeap.poll()
                if (curr > best[u]!!) {
                    continue
                }
                for ((v, w) in dist[u].orEmpty()) {
                    if (best.containsKey(v) && best[v]!! - curr <= w) {
                        continue
                    }
                    best[v] = curr + w
                    minHeap.add(best[v]!! to v)
                }
            }
            return best
        }

        val memo = HashMap<Int, HashMap<Int, Int>>()
        fun memoization(u: Int, v: Int): Int {
            if (!memo.containsKey(u)) {
                memo[u] = dijkstra(u)
            }
            return memo[u]!![v] ?: inf
        }

        var result = 0L
        for (i in source.indices) {
            val d = memoization(source[i] - 'a', target[i] - 'a')
            if (d == inf) {
                return -1
            }
            result += d
        }
        return result
    }
}
