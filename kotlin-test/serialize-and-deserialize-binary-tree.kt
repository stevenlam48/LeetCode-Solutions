package serializeanddeserializebinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SerializeAndDeserializeBinaryTreeTest {
    @Test
    fun exampleTree() {
        val root = treeOf(1, 2, 3, null, null, 4, 5)
        val codec = Codec()
        assertEquals(listOf(1, 2, 3, null, null, 4, 5), levelOrder(codec.deserialize(codec.serialize(root))))
    }

    @Test
    fun emptyTree() {
        val codec = Codec()
        assertEquals(emptyList<Int?>(), levelOrder(codec.deserialize(codec.serialize(null))))
    }

    @Test
    fun singleNode() {
        val codec = Codec()
        assertEquals(listOf(7), levelOrder(codec.deserialize(codec.serialize(treeOf(7)))))
    }

    @Test
    fun negativeValues() {
        val root = treeOf(-1, -2, -3, -4)
        val codec = Codec()
        assertEquals(listOf(-1, -2, -3, -4), levelOrder(codec.deserialize(codec.serialize(root))))
    }

    @Test
    fun leftSkewedTree() {
        val root = treeOf(1, 2, null, 3, null, 4)
        val codec = Codec()
        assertEquals(listOf(1, 2, null, 3, null, 4), levelOrder(codec.deserialize(codec.serialize(root))))
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
