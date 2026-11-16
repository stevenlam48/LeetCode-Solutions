package allpathsfromsourceleadtodestination

// Time:  O(n + e)
// Space: O(n + e)

class Solution {
    fun leadsToDestination(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val children = HashMap<Int, MutableList<Int>>()
        for (edge in edges) {
            children.getOrPut(edge[0]) { mutableListOf() }.add(edge[1])
        }
        val status = IntArray(n)
        return dfs(children, source, destination, status)
    }

    private fun dfs(
        children: HashMap<Int, MutableList<Int>>,
        node: Int,
        destination: Int,
        status: IntArray
    ): Boolean {
        if (status[node] == DONE) {
            return true
        }
        if (status[node] == VISITING) {
            return false
        }
        status[node] = VISITING
        if (!children.containsKey(node) && node != destination) {
            return false
        }
        children[node]?.let {
            for (child in it) {
                if (!dfs(children, child, destination, status)) {
                    return false
                }
            }
        }
        status[node] = DONE
        return true
    }

    private companion object {
        const val UNVISITED = 0
        const val VISITING = 1
        const val DONE = 2
    }
}
