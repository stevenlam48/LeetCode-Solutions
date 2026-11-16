package pathwithmaximumprobability

import java.util.PriorityQueue

// Time:  O((|E| + |V|) * log|V|) = O(|E| * log|V|) by using binary heap,
//        if we can further to use Fibonacci heap, it would be O(|E| + |V| * log|V|)
// Space: O(|E| + |V|) = O(|E|)

class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
        val adj = HashMap<Int, MutableList<Pair<Int, Double>>>()
        for (i in edges.indices) {
            adj.getOrPut(edges[i][0]) { mutableListOf() }.add(Pair(edges[i][1], succProb[i]))
            adj.getOrPut(edges[i][1]) { mutableListOf() }.add(Pair(edges[i][0], succProb[i]))
        }
        val maxHeap = PriorityQueue<Pair<Double, Int>>(compareByDescending<Pair<Double, Int>> { it.first }.thenByDescending { it.second })
        maxHeap.add(Pair(1.0, start))
        val result = HashMap<Int, Double>()
        val lookup = HashSet<Int>()
        while (maxHeap.isNotEmpty() && lookup.size != adj.size) {
            val (curr, u) = maxHeap.poll()
            if (u in lookup) {
                continue
            }
            lookup.add(u)
            for ((v, w) in adj.getOrDefault(u, mutableListOf())) {
                if (v in lookup) {
                    continue
                }
                if (result.containsKey(v) && result[v]!! >= curr * w) {
                    continue
                }
                result[v] = curr * w
                maxHeap.add(Pair(result[v]!!, v))
            }
        }
        return result.getOrDefault(end, 0.0)
    }
}
