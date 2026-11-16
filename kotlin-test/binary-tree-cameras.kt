package binarytreecameras

import common.TreeNode
import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeCamerasTest {
    @Test
    fun oneCameraCoversRootAndLeaves() {
        val root = treeOf(0, 0, null, 0, 0)
        assertEquals(1, Solution().minCameraCover(root))
    }

    @Test
    fun secondStandardExample() {
        val root = treeOf(0, 0, null, 0, null, 0, null, null, 0)
        assertEquals(2, Solution().minCameraCover(root))
    }

    @Test
    fun singleNodeNeedsOneCamera() {
        assertEquals(1, Solution().minCameraCover(treeOf(0)))
    }

    @Test
    fun emptyTreeNeedsNoCamera() {
        assertEquals(0, Solution().minCameraCover(null))
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
