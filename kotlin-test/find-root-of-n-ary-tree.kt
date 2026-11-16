package findrootofnarytree

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class FindRootOfNAryTreeTest {
    @Test
    fun testExample() {
        val n1 = Node(1)
        val n2 = Node(2)
        val n3 = Node(3)
        val n4 = Node(4)
        n1.children = mutableListOf(n2, n3)
        n2.children = mutableListOf(n4)
        assertSame(n1, Solution().findRoot(listOf(n1, n2, n3, n4)))
    }

    @Test
    fun testSingleNode() {
        val n1 = Node(1)
        assertSame(n1, Solution().findRoot(listOf(n1)))
    }

    @Test
    fun testStar() {
        val root = Node(10)
        val a = Node(1)
        val b = Node(2)
        val c = Node(3)
        root.children = mutableListOf(a, b, c)
        assertSame(root, Solution().findRoot(listOf(a, b, c, root)))
    }
}
