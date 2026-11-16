package possiblebipartition
import java.util.ArrayDeque
// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

class Solution {
    fun possibleBipartition(N: Int, dislikes: Array<IntArray>): Boolean {
        val adj = Array(N) { mutableListOf<Int>() }
        for (dislike in dislikes) {
            val u = dislike[0] - 1
            val v = dislike[1] - 1
            adj[u].add(v)
            adj[v].add(u)
        }
        val color = IntArray(N)
        color[0] = 1
        val q = ArrayDeque<Int>()
        q.add(0)
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            for (nei in adj[cur]) {
                if (color[nei] == color[cur]) {
                    return false
                } else if (color[nei] == -color[cur]) {
                    continue
                }
                color[nei] = -color[cur]
                q.add(nei)
            }
        }
        return true
    }
}
