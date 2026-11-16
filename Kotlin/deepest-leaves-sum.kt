package deepestleavessum

// Time:  O(n)
// Space: O(w)
import common.TreeNode

class Solution {
    fun deepestLeavesSum(root: TreeNode?): Int {
        var curr = listOf(root)
        var prev = emptyList<TreeNode?>()
        while (curr.isNotEmpty()) {
            prev = curr
            val next = mutableListOf<TreeNode?>()
            for (p in prev) {
                for (child in listOf(p?.left, p?.right)) {
                    if (child != null) next.add(child)
                }
            }
            curr = next
        }
        return prev.sumOf { it!!.`val` }
    }
}
