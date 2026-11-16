package movesubtreeofnarytree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MoveSubTreeOfNAryTreeTest {
    private fun node(value: Int, vararg children: Node): Node {
        val n = Node(value)
        n.children.addAll(children)
        return n
    }

    private fun serialize(root: Node?): String {
        if (root == null) {
            return ""
        }
        if (root.children.isEmpty()) {
            return root.`val`.toString()
        }
        return root.`val`.toString() + "(" + root.children.joinToString(",") { serialize(it) } + ")"
    }

    @Test
    fun moveToSibling() {
        val a = node(2)
        val b = node(3)
        val root = node(1, a, b)
        val result = Solution().moveSubTree(root, a, b)
        assertEquals("1(3(2))", serialize(result))
    }

    @Test
    fun alreadyChild() {
        val c = node(3)
        val b = node(2, c)
        val root = node(1, b)
        val result = Solution().moveSubTree(root, c, b)
        assertEquals("1(2(3))", serialize(result))
    }

    @Test
    fun moveAncestorUnderDescendant() {
        val c = node(3)
        val b = node(2, c)
        val d = node(4)
        val root = node(1, b, d)
        val result = Solution().moveSubTree(root, b, c)
        assertEquals("1(3(2),4)", serialize(result))
    }

    @Test
    fun moveRootUnderDescendant() {
        val c = node(3)
        val b = node(2, c)
        val root = node(1, b)
        val result = Solution().moveSubTree(root, root, c)
        assertEquals("3(1(2))", serialize(result))
    }

    @Test
    fun moveLeafToOtherBranch() {
        val e = node(5)
        val d = node(4, e)
        val c = node(3)
        val b = node(2, c)
        val root = node(1, b, d)
        val result = Solution().moveSubTree(root, e, c)
        assertEquals("1(2(3(5)),4)", serialize(result))
    }
}
