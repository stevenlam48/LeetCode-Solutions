package isarrayapreorderofsomebinarytree

// Time:  O(n)
// Space: O(n)

class Solution {
    fun isPreorder(nodes: Array<IntArray>): Boolean {
        val stk = mutableListOf(nodes[0][0])
        for (i in 1 until nodes.size) {
            while (stk.isNotEmpty() && stk[stk.size - 1] != nodes[i][1]) {
                stk.removeAt(stk.size - 1)
            }
            if (stk.isEmpty()) {
                return false
            }
            stk.add(nodes[i][0])
        }
        return true
    }
}
