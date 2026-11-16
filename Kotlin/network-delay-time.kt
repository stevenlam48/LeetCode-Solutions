package networkdelaytime
// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

import java.util.PriorityQueue

class Solution {
    fun networkDelayTime(times: Array<IntArray>, N: Int, K: Int): Int {
        val adj = Array(N) { mutableListOf<Pair<Int, Int>>() }
        for (time in times) {
            val u = time[0] - 1
            val v = time[1] - 1
            val w = time[2]
            adj[u].add(v to w)
        }
        var result = 0
        val lookup = HashSet<Int>()
        val best = HashMap<Int, Int>()
        best[K - 1] = 0
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        minHeap.add(0 to K - 1)
        while (minHeap.isNotEmpty() && lookup.size != N) {
            val current = minHeap.poll()
            result = current.first
            val u = current.second
            lookup.add(u)
            if (best.containsKey(u) && best[u]!! < result) {
                continue
            }
            for ((v, w) in adj[u]) {
                if (v in lookup) {
                    continue
                }
                if (!best.containsKey(v) || result + w < best[v]!!) {
                    best[v] = result + w
                    minHeap.add(result + w to v)
                }
            }
        }
        return if (lookup.size == N) result else -1
    }
}
