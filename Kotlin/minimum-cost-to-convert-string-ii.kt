package minimumcosttoconvertstringii
// Time:  O(o * l + k * eloge + n * c * l), e is the number of edges reachable from a given node u, o = len(original), l = max(len(x) for x in original), k = len(lookups), c = len({len(x) for x in original})
// Space: O(o * l + k * v + c + l), v is the number of nodes reachable from a given node u

import java.util.PriorityQueue

class Solution {
    fun minimumCost(source: String, target: String, original: List<String>, changed: List<String>, cost: IntArray): Long {
        val inf = Long.MAX_VALUE
        val lookups = HashMap<Int, HashMap<String, Int>>()
        for (x in original + changed) {
            val lookup = lookups.getOrPut(x.length) { HashMap() }
            if (!lookup.containsKey(x)) {
                lookup[x] = lookup.size
            }
        }
        val dists = HashMap<Int, Array<LongArray>>()
        for ((length, lookup) in lookups) {
            dists[length] = Array(lookup.size) { u -> LongArray(lookup.size) { v -> if (u == v) 0L else inf } }
        }
        for (i in original.indices) {
            val length = original[i].length
            val lookup = lookups[length]!!
            val dist = dists[length]!!
            val u = lookup[original[i]]!!
            val v = lookup[changed[i]]!!
            dist[u][v] = minOf(dist[u][v], cost[i].toLong())
        }

        fun dijkstra(dist: Array<LongArray>, start: Int): LongArray {
            val best = LongArray(dist.size) { inf }
            best[start] = 0
            val minHeap = PriorityQueue<Pair<Long, Int>>(compareBy<Pair<Long, Int>> { it.first }.thenBy { it.second })
            minHeap.add(0L to start)
            while (minHeap.isNotEmpty()) {
                val (curr, u) = minHeap.poll()
                if (curr > best[u]) {
                    continue
                }
                for (v in dist[u].indices) {
                    val w = dist[u][v]
                    if (best[v] - curr <= w) {
                        continue
                    }
                    best[v] = curr + w
                    minHeap.add(best[v] to v)
                }
            }
            return best
        }

        val memo = HashMap<Int, HashMap<Int, LongArray>>()
        fun memoization(length: Int, dist: Array<LongArray>, u: Int, v: Int): Long {
            val byStart = memo.getOrPut(length) { HashMap() }
            if (!byStart.containsKey(u)) {
                byStart[u] = dijkstra(dist, u)
            }
            return byStart[u]!![v]
        }

        val candidates = HashSet<Int>()
        var maxLength = 0
        for (x in original) {
            candidates.add(x.length)
            maxLength = maxOf(maxLength, x.length)
        }
        val dp = LongArray(maxLength + 1) { inf }
        dp[0] = 0
        for (i in source.indices) {
            if (dp[i % dp.size] == inf) {
                continue
            }
            if (source[i] == target[i]) {
                val next = (i + 1) % dp.size
                dp[next] = minOf(dp[next], dp[i % dp.size])
            }
            for (length in candidates) {
                if (i + length > source.length) {
                    continue
                }
                val lookup = lookups[length]!!
                val dist = dists[length]!!
                val u = source.substring(i, i + length)
                val v = target.substring(i, i + length)
                if (lookup.containsKey(u) && lookup.containsKey(v)) {
                    val d = memoization(length, dist, lookup[u]!!, lookup[v]!!)
                    if (d != inf) {
                        val next = (i + length) % dp.size
                        dp[next] = minOf(dp[next], dp[i % dp.size] + d)
                    }
                }
            }
            dp[i % dp.size] = inf
        }
        val result = dp[source.length % dp.size]
        return if (result != inf) result else -1
    }
}
