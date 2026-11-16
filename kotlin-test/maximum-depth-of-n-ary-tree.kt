package maximumdepthofnarytree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDepthOfNAryTreeTest {
    @Test
    fun emptyTree() {
        assertEquals(0, Solution().maxDepth(null))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().maxDepth(Node(1)))
    }

    @Test
    fun standardTree() {
        val root = Node(
            1,
            listOf(
                Node(3, listOf(Node(5), Node(6))),
                Node(2),
                Node(4),
            ),
        )
        assertEquals(3, Solution().maxDepth(root))
    }

    @Test
    fun unbalancedTree() {
        val root = Node(1, listOf(Node(2), Node(3, listOf(Node(4, listOf(Node(5)))))))
        assertEquals(4, Solution().maxDepth(root))
    }
}
