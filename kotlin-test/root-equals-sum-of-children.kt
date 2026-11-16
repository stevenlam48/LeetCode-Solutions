package rootequalssumofchildren

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RootEqualsSumOfChildrenTest {
    @Test
    fun leetCodeExampleValid() {
        assertTrue(Solution().checkTree(treeOf(10, 4, 6)))
    }

    @Test
    fun leetCodeExampleInvalid() {
        assertFalse(Solution().checkTree(treeOf(5, 3, 1)))
    }

    @Test
    fun zeroRootWithZeroChildren() {
        assertTrue(Solution().checkTree(treeOf(0, 0, 0)))
    }

    @Test
    fun negativeValues() {
        assertTrue(Solution().checkTree(treeOf(-3, -1, -2)))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.addLast(root)
    var i = 1
    while (queue.isNotEmpty() && i < v.size) {
        val node = queue.removeFirst()
        val left = v[i++]
        if (left != null) {
            node.left = TreeNode(left)
            queue.addLast(node.left!!)
        }
        if (i < v.size) {
            val right = v[i++]
            if (right != null) {
                node.right = TreeNode(right)
                queue.addLast(node.right!!)
            }
        }
    }
    return root
}
