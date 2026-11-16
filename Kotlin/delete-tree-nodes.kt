package deletetreenodes

// Time:  O(n)
// Space: O(n)

class Solution {
    fun deleteTreeNodes(nodes: Int, parent: IntArray, value: IntArray): Int {
        val children = HashMap<Int, MutableList<Int>>()
        for (i in 1 until parent.size) {
            children.getOrPut(parent[i]) { mutableListOf() }.add(i)
        }
        return dfs(value, children, 0).second
    }

    private fun dfs(value: IntArray, children: HashMap<Int, MutableList<Int>>, x: Int): Pair<Int, Int> {
        var total = value[x]
        var count = 1
        for (y in children[x] ?: emptyList<Int>()) {
            val (t, c) = dfs(value, children, y)
            total += t
            count += if (t != 0) c else 0
        }
        return Pair(total, if (total != 0) count else 0)
    }
}
