package maximumbinarytreeii

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBinaryTreeIiTest {
    @Test
    fun newRoot() {
        assertEquals(
            listOf(5, 4, 1, null, null, 3, 2, null, null, null, null),
            preorder(Solution().insertIntoMaxTree(treeOf(4, 1, 3, null, null, 2), 5))
        )
    }

    @Test
    fun insertedInsideRightSpine() {
        assertEquals(
            listOf(5, 2, null, 1, null, null, 4, null, 3, null, null),
            preorder(Solution().insertIntoMaxTree(treeOf(5, 2, 4, null, 1), 3))
        )
    }

    @Test
    fun emptyTree() {
        assertEquals(
            listOf(3, null, null),
            preorder(Solution().insertIntoMaxTree(null, 3))
        )
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var index = 1
    while (index < values.size) {
        val curr = queue.removeFirst()
        values[index]?.let {
            curr.left = TreeNode(it)
            queue.add(curr.left!!)
        }
        index++
        if (index < values.size) {
            values[index]?.let {
                curr.right = TreeNode(it)
                queue.add(curr.right!!)
            }
            index++
        }
    }
    return root
}

private fun preorder(root: TreeNode?): List<Int?> {
    if (root == null) {
        return listOf(null)
    }
    return listOf(root.`val`) + preorder(root.left) + preorder(root.right)
}
