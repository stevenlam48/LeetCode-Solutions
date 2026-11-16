package findchampionii

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findChampion(n: Int, edges: Array<IntArray>): Int {
        val lookup = IntArray(n)
        for (edge in edges) {
            lookup[edge[1]] = 1
        }
        var result = -1
        for (u in 0 until n) {
            if (lookup[u] != 0) {
                continue
            }
            if (result != -1) {
                return -1
            }
            result = u
        }
        return result
    }
}
