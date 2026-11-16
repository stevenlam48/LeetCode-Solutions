package addedgestomakedegreesofallnodeseven

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isPossible(n: Int, edges: Array<IntArray>): Boolean {
        val adj = Array(n) { HashSet<Int>() }
        for (e in edges) {
            adj[e[0] - 1].add(e[1] - 1)
            adj[e[1] - 1].add(e[0] - 1)
        }
        val odds = mutableListOf<Int>()
        for (u in 0 until n) {
            if (adj[u].size % 2 != 0) {
                odds.add(u)
            }
        }
        if (odds.size == 0) {
            return true
        }
        if (odds.size == 2) {
            for (u in 0 until n) {
                if (odds[0] !in adj[u] && odds[1] !in adj[u]) {
                    return true
                }
            }
            return false
        }
        if (odds.size == 4) {
            return (odds[0] !in adj[odds[1]] && odds[2] !in adj[odds[3]]) ||
                (odds[0] !in adj[odds[2]] && odds[1] !in adj[odds[3]]) ||
                (odds[0] !in adj[odds[3]] && odds[1] !in adj[odds[2]])
        }
        return false
    }
}
