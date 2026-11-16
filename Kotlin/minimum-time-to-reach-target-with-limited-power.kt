package minimumtimetoreachtargetwithlimitedpower

// Time:  O((n * p + e * p) * log(n * p))
// Space: O(n * p)

import java.util.PriorityQueue

private data class State(val time: Long, val remaining: Int, val node: Int)

class Solution {
    fun minTimeMaxPower(
        n: Int,
        edges: Array<IntArray>,
        power: Int,
        cost: IntArray,
        source: Int,
        target: Int
    ): LongArray {
        val adjacency = Array(n) { mutableListOf<Pair<Int, Int>>() }
        for (edge in edges) {
            adjacency[edge[0]].add(edge[1] to edge[2])
        }
        val distance = Array(n) { LongArray(power + 1) { Long.MAX_VALUE } }
        distance[source][power] = 0
        val heap = PriorityQueue(compareBy<State> { it.time }.thenBy { -it.remaining })
        heap.add(State(0L, power, source))
        while (heap.isNotEmpty()) {
            val (time, remaining, u) = heap.poll()
            if (time > distance[u][remaining]) {
                continue
            }
            if (u == target) {
                return longArrayOf(time, remaining.toLong())
            }
            val nextPower = remaining - cost[u]
            if (nextPower < 0) {
                continue
            }
            for ((v, weight) in adjacency[u]) {
                val nextTime = time + weight
                if (nextTime >= distance[v][nextPower]) {
                    continue
                }
                distance[v][nextPower] = nextTime
                heap.add(State(nextTime, nextPower, v))
            }
        }
        return longArrayOf(-1, -1)
    }
}
