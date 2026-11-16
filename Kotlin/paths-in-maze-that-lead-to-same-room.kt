package pathsinmazethatleadtosameroom

// Time:  O(|V|^3)
// Space: O(|E|)

class Solution {
    fun numberOfPaths(n: Int, corridors: Array<IntArray>): Int {
        val adj = Array(n) { HashSet<Int>() }
        for (x in corridors) {
            adj[minOf(x[0], x[1]) - 1].add(maxOf(x[0], x[1]) - 1)
        }
        var result = 0
        for (i in 0 until n) {
            for (j in adj[i]) {
                for (k in adj[j]) {
                    if (k in adj[i]) {
                        ++result
                    }
                }
            }
        }
        return result
    }
}
