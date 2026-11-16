package encodenarytreetobinarytree

import common.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class EncodeNAryTreeToBinaryTreeTest {
    private val codec = Codec()

    @Test
    fun `null tree round trips`() {
        assertNull(codec.encode(null))
        assertNull(codec.decode(null))
    }

    @Test
    fun `single node has no binary or nary children`() {
        val encoded = codec.encode(Node(7))
        val expectedBinary = TreeNode(7)
        assertBinaryEquals(expectedBinary, encoded)

        val decoded = codec.decode(encoded)
        assertBinaryEquals(expectedBinary, codec.encode(decoded))
        assertEquals(7, decoded?.`val`)
        assertEquals(emptyList<Node?>(), decoded?.children)
    }

    @Test
    fun `encodes first child right and following siblings left`() {
        val root = node(1, node(3, node(5), node(6)), node(2), node(4))
        val expectedBinary = TreeNode(1).apply {
            right = TreeNode(3).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                }
                right = TreeNode(5).apply {
                    left = TreeNode(6)
                }
            }
        }

        val encoded = codec.encode(root)

        assertBinaryEquals(expectedBinary, encoded)
        assertNaryEquals(root, codec.decode(encoded))
    }

    @Test
    fun `deep and uneven tree round trips without reordering children`() {
        val root = node(
            10,
            node(20, node(50)),
            node(30, node(60, node(90)), node(70)),
            node(40, node(80))
        )

        val decoded = codec.decode(codec.encode(root))

        assertNaryEquals(root, decoded)
    }
}

private fun node(value: Int, vararg children: Node): Node {
    return Node(value, children.map { it as Node? }.toMutableList())
}

private fun assertBinaryEquals(expected: TreeNode?, actual: TreeNode?) {
    if (expected == null || actual == null) {
        assertEquals(expected, actual)
        return
    }
    assertEquals(expected.`val`, actual.`val`)
    assertBinaryEquals(expected.left, actual.left)
    assertBinaryEquals(expected.right, actual.right)
}

private fun assertNaryEquals(expected: Node?, actual: Node?) {
    if (expected == null || actual == null) {
        assertEquals(expected, actual)
        return
    }
    assertEquals(expected.`val`, actual.`val`)
    assertEquals(expected.children.size, actual.children.size)
    for (i in expected.children.indices) {
        assertNaryEquals(expected.children[i], actual.children[i])
    }
}
