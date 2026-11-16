package minimumcostofapathwithspecialroads

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun minimumCost(start: IntArray, target: IntArray, specialRoads: Array<IntArray>): Int {
        val INF = Int.MAX_VALUE

        fun id(x: Int, y: Int): Long = (x - 1).toLong() * target[1] + (y - 1)
        fun xOf(v: Long): Int = (v / target[1] + 1).toInt()
        fun yOf(v: Long): Int = (v % target[1] + 1).toInt()

        val s = id(start[0], start[1])
        val t = id(target[0], target[1])
        val adj = HashMap<Long, MutableList<Pair<Long, Int>>>()
        adj[t] = mutableListOf()
        for (road in specialRoads) {
            val u = id(road[0], road[1])
            val v = id(road[2], road[3])
            adj.getOrPut(u) { mutableListOf() }.add(Pair(v, road[4]))
        }
        val dist = HashMap<Long, Int>()
        dist[s] = 0
        val lookup = HashSet<Long>()
        while (lookup.size != dist.size) {
            var bestD = INF
            var u = -1L
            for ((node, d) in dist) {
                if (node !in lookup && (d < bestD || (d == bestD && node < u))) {
                    bestD = d
                    u = node
                }
            }
            lookup.add(u)
            if (u == t) {
                return bestD
            }
            for ((v, c) in adj[u] ?: emptyList()) {
                if (!dist.containsKey(v) || dist.getValue(v) > bestD + c) {
                    dist[v] = bestD + c
                }
            }
            val x1 = xOf(u)
            val y1 = yOf(u)
            for (v in adj.keys) {
                val x2 = xOf(v)
                val y2 = yOf(v)
                val cand = bestD + kotlin.math.abs(x2 - x1) + kotlin.math.abs(y2 - y1)
                if (!dist.containsKey(v) || dist.getValue(v) > cand) {
                    dist[v] = cand
                }
            }
        }
        return -1
    }
}
