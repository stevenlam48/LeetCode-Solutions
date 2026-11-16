package minimumedgereversalssoeverynodeisreachable
// Time:  O(n)
// Space: O(n)

class Solution {
    fun minEdgeReversals(n: Int, edges: Array<IntArray>): IntArray {
        val adj = Array(n) { HashMap<Int, Int>() }
        for (e in edges) {
            adj[e[0]][e[1]] = 0
            adj[e[1]][e[0]] = 1
        }
        var initial = 0
        val firstStack = ArrayDeque<Pair<Int, Int>>()
        firstStack.add(0 to -1)
        while (firstStack.isNotEmpty()) {
            val (u, p) = firstStack.removeLast()
            for ((v, _) in adj[u]) {
                if (v == p) {
                    continue
                }
                initial += adj[u].getValue(v)
                firstStack.add(v to u)
            }
        }

        val result = IntArray(n) { -1 }
        val secondStack = ArrayDeque<Pair<Int, Int>>()
        secondStack.add(0 to initial)
        while (secondStack.isNotEmpty()) {
            val (u, curr) = secondStack.removeLast()
            result[u] = curr
            for ((v, _) in adj[u]) {
                if (result[v] == -1) {
                    secondStack.add(v to curr - adj[u].getValue(v) + adj[v].getValue(u))
                }
            }
        }
        return result
    }
}
