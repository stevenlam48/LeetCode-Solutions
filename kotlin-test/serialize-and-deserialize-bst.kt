package serializeanddeserializebst

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SerializeAndDeserializeBstTest {
    @Test
    fun exampleTree() {
        val root = treeOf(2, 1, 3)
        val codec = Codec()
        assertEquals(listOf(2, 1, 3), levelOrder(codec.deserialize(codec.serialize(root))))
    }

    @Test
    fun emptyTree() {
        val codec = Codec()
        assertEquals(emptyList<Int?>(), levelOrder(codec.deserialize(codec.serialize(null))))
    }

    @Test
    fun singleNode() {
        val codec = Codec()
        assertEquals(listOf(5), levelOrder(codec.deserialize(codec.serialize(treeOf(5)))))
    }

    @Test
    fun balancedTree() {
        val root = treeOf(5, 3, 6, 2, 4, null, 7)
        val codec = Codec()
        assertEquals(listOf(5, 3, 6, 2, 4, null, 7), levelOrder(codec.deserialize(codec.serialize(root))))
    }

    @Test
    fun negativeValues() {
        val root = treeOf(-10, -20, -5)
        val codec = Codec()
        assertEquals(listOf(-10, -20, -5), levelOrder(codec.deserialize(codec.serialize(root))))
    }

    @Test
    fun rightSkewedTree() {
        val root = treeOf(1, null, 2, null, 3)
        val codec = Codec()
        assertEquals(listOf(1, null, 2, null, 3), levelOrder(codec.deserialize(codec.serialize(root))))
    }
}

private fun treeOf(vararg v: Int?): TreeNode? {
    if (v.isEmpty() || v[0] == null) {
        return null
    }
    val root = TreeNode(v[0]!!)
    val q = ArrayDeque<TreeNode>()
    q.addLast(root)
    var i = 1
    while (q.isNotEmpty() && i < v.size) {
        val node = q.removeFirst()
        if (i < v.size) {
            val left = v[i++]
            if (left != null) {
                node.left = TreeNode(left)
                q.addLast(node.left!!)
            }
        }
        if (i < v.size) {
            val right = v[i++]
            if (right != null) {
                node.right = TreeNode(right)
                q.addLast(node.right!!)
            }
        }
    }
    return root
}

private fun levelOrder(root: TreeNode?): List<Int?> {
    if (root == null) {
        return emptyList()
    }
    val result = ArrayList<Int?>()
    val q = ArrayDeque<TreeNode?>()
    q.addLast(root)
    while (q.isNotEmpty()) {
        val node = q.removeFirst()
        if (node == null) {
            result.add(null)
            continue
        }
        result.add(node.`val`)
        q.addLast(node.left)
        q.addLast(node.right)
    }
    while (result.isNotEmpty() && result.last() == null) {
        result.removeAt(result.size - 1)
    }
    return result
}
