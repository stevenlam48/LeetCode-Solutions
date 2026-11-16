package deletenodesandreturnforest

// Time:  O(n)
// Space: O(h + d), d is the number of to_delete
import common.TreeNode

class Solution {
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode> {
        val result = mutableListOf<TreeNode>()
        val toDeleteSet = to_delete.toHashSet()
        delNodesHelper(toDeleteSet, root, true, result)
        return result
    }

    private fun delNodesHelper(
        toDeleteSet: HashSet<Int>,
        root: TreeNode?,
        isRoot: Boolean,
        result: MutableList<TreeNode>
    ): TreeNode? {
        if (root == null) return null
        val isDeleted = toDeleteSet.contains(root.`val`)
        if (isRoot && !isDeleted) result.add(root)
        root.left = delNodesHelper(toDeleteSet, root.left, isDeleted, result)
        root.right = delNodesHelper(toDeleteSet, root.right, isDeleted, result)
        return if (isDeleted) null else root
    }
}
