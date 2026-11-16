package diameterofnarytree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DiameterOfNAryTreeTest {
    private val solution = Solution()

    @Test
    fun diameterUsesTwoDeepestBranches() {
        val root = node(
            1,
            node(3, node(5), node(6)),
            node(2),
            node(4)
        )
        assertEquals(3, solution.diameter(root))
    }

    @Test
    fun diameterCanLieWithinOneChildSubtree() {
        val root = node(
            1,
            node(2),
            node(
                3,
                node(6, node(11, node(14))),
                node(7, node(12, node(15)))
            )
        )
        assertEquals(6, solution.diameter(root))
    }

    @Test
    fun pathHasNodeCountMinusOneEdges() {
        assertEquals(3, solution.diameter(node(1, node(2, node(3, node(4))))))
    }

    @Test
    fun singleNodeHasZeroDiameter() {
        assertEquals(0, solution.diameter(node(1)))
    }

    @Test
    fun starTreeHasDiameterTwo() {
        assertEquals(2, solution.diameter(node(1, node(2), node(3), node(4))))
    }
}

private fun node(value: Int, vararg children: Node): Node =
    Node(value).also { it.children = children.toList() }
