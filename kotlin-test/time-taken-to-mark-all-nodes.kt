package timetakentomarkallnodes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TimeTakenToMarkAllNodesTest {
    private val solution = Solution()

    @Test
    fun threeNodeStar() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(2, 4, 3), solution.timeTaken(edges))
    }

    @Test
    fun threeNodeChain() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(3, 2, 3), solution.timeTaken(edges))
    }

    @Test
    fun fourNodeStar() {
        val edges = arrayOf(intArrayOf(2, 0), intArrayOf(2, 1), intArrayOf(2, 3))
        assertArrayEquals(intArrayOf(3, 4, 2, 4), solution.timeTaken(edges))
    }

    @Test
    fun singleNode() {
        assertArrayEquals(intArrayOf(0), solution.timeTaken(emptyArray()))
    }
}
