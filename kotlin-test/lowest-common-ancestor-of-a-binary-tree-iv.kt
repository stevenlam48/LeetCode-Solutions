package lowestcommonancestorofabinarytreeiv

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class LowestCommonAncestorOfABinaryTreeIvTest {
    @Test
    fun findsAncestorForNodesInDifferentSubtrees() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val targets = listOf(node(root, 5), node(root, 1))
        assertSame(node(root, 3), Solution().lowestCommonAncestor(root, targets))
    }

    @Test
    fun findsAncestorWithinOneSubtree() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val targets = listOf(node(root, 6), node(root, 4))
        assertSame(node(root, 5), Solution().lowestCommonAncestor(root, targets))
    }

    @Test
    fun returnsTargetThatContainsAnotherTarget() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val targets = listOf(node(root, 5), node(root, 4))
        assertSame(node(root, 5), Solution().lowestCommonAncestor(root, targets))
    }

    @Test
    fun handlesSingleTarget() {
        val root = treeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val target = node(root, 7)
        assertSame(target, Solution().lowestCommonAncestor(root, listOf(target)))
    }

    @Test
    fun handlesNoTargets() {
        val root = treeOf(1, 2, 3)
        assertNull(Solution().lowestCommonAncestor(root, emptyList()))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) {
        return null
    }
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (i < values.size && queue.isNotEmpty()) {
        val parent = queue.removeFirst()
        values[i++]?.let {
            val child = TreeNode(it)
            parent.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                parent.right = child
                queue.add(child)
            }
        }
    }
    return root
}

private fun node(root: TreeNode?, value: Int): TreeNode {
    val queue = ArrayDeque<TreeNode>()
    root?.let(queue::add)
    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()
        if (current.`val` == value) {
            return current
        }
        current.left?.let(queue::add)
        current.right?.let(queue::add)
    }
    throw IllegalArgumentException("Missing node $value")
}
