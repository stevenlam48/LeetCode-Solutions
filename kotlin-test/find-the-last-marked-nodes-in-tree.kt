package findthelastmarkednodesintree

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheLastMarkedNodesInTreeTest {
    @Test
    fun pathOfThree() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(2, 0, 0), Solution().lastMarkedNodes(edges))
    }

    @Test
    fun star() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(2, 2, 1), Solution().lastMarkedNodes(edges))
    }

    @Test
    fun singleEdge() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(1, 0), Solution().lastMarkedNodes(edges))
    }

    @Test
    fun pathOfFive() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertArrayEquals(intArrayOf(4, 4, 0, 0, 0), Solution().lastMarkedNodes(edges))
    }
}
