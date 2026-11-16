package timeneededtoinformallemployees
// Time:  O(n)
// Space: O(n)

class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val children = HashMap<Int, MutableList<Int>>()
        for (i in manager.indices) {
            if (manager[i] != -1) {
                children.getOrPut(manager[i]) { mutableListOf() }.add(i)
            }
        }

        var result = 0
        val stack = mutableListOf(Pair(headID, 0))
        while (stack.isNotEmpty()) {
            val (node, previous) = stack.removeAt(stack.lastIndex)
            val current = previous + informTime[node]
            result = maxOf(result, current)
            val subordinates = children[node] ?: continue
            for (child in subordinates) {
                stack.add(Pair(child, current))
            }
        }
        return result
    }
}
