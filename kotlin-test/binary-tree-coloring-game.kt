package binarytreecoloringgame

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinaryTreeColoringGameTest {
    @Test
    fun choosingACriticalSubtreeWins() {
        val root = treeOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        assertTrue(Solution().btreeGameWinningMove(root, 11, 3))
    }

    @Test
    fun rootOfSmallBalancedTreeLoses() {
        assertFalse(Solution().btreeGameWinningMove(treeOf(1, 2, 3), 3, 1))
    }

    @Test
    fun leafOfSmallBalancedTreeWins() {
        assertTrue(Solution().btreeGameWinningMove(treeOf(1, 2, 3), 3, 2))
    }

    @Test
    fun rootCanWinOnAnUnbalancedTree() {
        assertTrue(Solution().btreeGameWinningMove(treeOf(1, 2, null, 4), 3, 1))
    }
}

private fun treeOf(vararg values: Int?): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        values[i++]?.let {
            val child = TreeNode(it)
            node.left = child
            queue.add(child)
        }
        if (i < values.size) {
            values[i++]?.let {
                val child = TreeNode(it)
                node.right = child
                queue.add(child)
            }
        }
    }
    return root
}
