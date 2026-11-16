package validarrangementofpairs

// Time:  O(|V| + |E|)
// Space: O(|V| + |E|)

class Solution {
    fun validArrangement(pairs: Array<IntArray>): Array<IntArray> {
        val adj = HashMap<Int, MutableList<Int>>()
        val degree = HashMap<Int, Int>()
        for (pair in pairs) {
            adj.getOrPut(pair[0]) { ArrayList() }.add(pair[1])
            degree[pair[0]] = (degree[pair[0]] ?: 0) + 1
            degree[pair[1]] = (degree[pair[1]] ?: 0) - 1
        }
        var x = -1
        for ((key, value) in degree) {
            if (value == 1) {
                x = key
                break
            }
            if (x == -1) {
                x = key
            }
        }
        val route = ArrayList<Int>()
        val stack = mutableListOf(x)
        while (stack.isNotEmpty()) {
            while (adj.getOrPut(stack.last()) { ArrayList() }.isNotEmpty()) {
                val next = adj[stack.last()]!!.removeAt(adj[stack.last()]!!.lastIndex)
                stack.add(next)
            }
            route.add(stack.removeAt(stack.lastIndex))
        }
        route.reverse()
        return Array(route.size - 1) { i -> intArrayOf(route[i], route[i + 1]) }
    }
}
