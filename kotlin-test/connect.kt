package connect

import java.util.ArrayDeque
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ConnectTest {
    @Test
    fun connectsEveryLevelOfPerfectTree() {
        val root = linkTreeOf(1, 2, 3, 4, 5, 6, 7)
        Solution().connect(root)
        assertLevel(listOf(2, 3), root?.left)
        assertLevel(listOf(4, 5, 6, 7), root?.left?.left)
    }

    @Test
    fun connectsSparseTreeWithoutUsingParentPointers() {
        val root = linkTreeOf(1, 2, 3, 4, 5, null, 7)
        Solution().connect(root)
        assertLevel(listOf(2, 3), root?.left)
        assertLevel(listOf(4, 5, 7), root?.left?.left)
    }

    @Test
    fun handlesSingleNodeAndNullTree() {
        val root = linkTreeOf(1)
        Solution().connect(root)
        assertNull(root?.next)
        Solution().connect(null)
    }
}

private fun linkTreeOf(vararg values: Int?): TreeLinkNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeLinkNode(values[0]!!)
    val queue = ArrayDeque<TreeLinkNode>()
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < values.size) {
        val node = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            node.left = TreeLinkNode(values[i]!!)
            queue.add(node.left)
        }
        ++i
        if (i < values.size && values[i] != null) {
            node.right = TreeLinkNode(values[i]!!)
            queue.add(node.right)
        }
        ++i
    }
    return root
}

private fun assertLevel(expected: List<Int>, first: TreeLinkNode?) {
    val actual = mutableListOf<Int>()
    var node = first
    while (node != null) {
        actual.add(node.`val`)
        node = node.next
    }
    assertEquals(expected, actual)
}
