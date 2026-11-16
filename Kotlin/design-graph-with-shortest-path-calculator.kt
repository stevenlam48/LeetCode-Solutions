package designgraphwithshortestpathcalculator

// Time:  ctor:         O(|V| + |E|)
//        addEdge:      O(1)
//        shortestPath: O((|E| + |V|) * log|V|) = O(|E| * log|V|)
// Space: O(|E| + |V|) = O(|E|)
import java.util.PriorityQueue

class Graph(n: Int, edges: Array<IntArray>) {
    private val adjacency = Array(n) { mutableListOf<Pair<Int, Int>>() }

    init {
        for (edge in edges) {
            addEdge(edge)
        }
    }

    fun addEdge(edge: IntArray) {
        adjacency[edge[0]].add(edge[1] to edge[2])
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val best = IntArray(adjacency.size) { Int.MAX_VALUE }
        best[node1] = 0
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }, { it.second }))
        minHeap.add(0 to node1)
        while (minHeap.isNotEmpty()) {
            val (current, u) = minHeap.poll()
            if (current > best[u]) {
                continue
            }
            if (u == node2) {
                break
            }
            for ((v, w) in adjacency[u]) {
                if (w >= best[v] - current) {
                    continue
                }
                best[v] = current + w
                minHeap.add(best[v] to v)
            }
        }
        return if (best[node2] != Int.MAX_VALUE) best[node2] else -1
    }
}
