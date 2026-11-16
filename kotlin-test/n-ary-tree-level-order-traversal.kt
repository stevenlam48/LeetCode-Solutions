package narytreelevelordertraversal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NAryTreeLevelOrderTraversalTest {
    private fun node(value: Int, vararg children: Node): Node {
        val n = Node(value)
        n.children.addAll(children)
        return n
    }

    @Test
    fun example() {
        val five = node(5)
        val six = node(6)
        val three = node(3, five, six)
        val two = node(2)
        val four = node(4)
        val root = node(1, three, two, four)
        assertEquals(
            listOf(listOf(1), listOf(3, 2, 4), listOf(5, 6)),
            Solution().levelOrder(root)
        )
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<List<Int>>(), Solution().levelOrder(null))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(listOf(1)), Solution().levelOrder(node(1)))
    }

    @Test
    fun deepChain() {
        val root = node(1, node(2, node(3, node(4))))
        assertEquals(listOf(listOf(1), listOf(2), listOf(3), listOf(4)), Solution().levelOrder(root))
    }

    @Test
    fun wideTree() {
        val root = node(1, node(2), node(3), node(4), node(5))
        assertEquals(listOf(listOf(1), listOf(2, 3, 4, 5)), Solution().levelOrder(root))
    }
}
