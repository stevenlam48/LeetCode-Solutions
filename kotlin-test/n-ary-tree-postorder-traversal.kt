package narytreepostordertraversal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NAryTreePostorderTraversalTest {
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
        assertEquals(listOf(5, 6, 3, 2, 4, 1), Solution().postorder(root))
    }

    @Test
    fun emptyTree() {
        assertEquals(emptyList<Int>(), Solution().postorder(null))
    }

    @Test
    fun singleNode() {
        assertEquals(listOf(1), Solution().postorder(node(1)))
    }

    @Test
    fun deepChain() {
        val root = node(1, node(2, node(3, node(4))))
        assertEquals(listOf(4, 3, 2, 1), Solution().postorder(root))
    }

    @Test
    fun wideTree() {
        val root = node(1, node(2), node(3), node(4))
        assertEquals(listOf(2, 3, 4, 1), Solution().postorder(root))
    }
}
