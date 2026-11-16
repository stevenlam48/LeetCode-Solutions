package maximumsubtreeofthesamecolor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubtreeOfTheSameColorTest {
    private val solution = Solution()

    @Test
    fun entireTreeHasOneColor() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertEquals(4, solution.maximumSubtreeSize(edges, intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun rootAndOneChildMatch() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        assertEquals(1, solution.maximumSubtreeSize(edges, intArrayOf(1, 1, 2, 3)))
    }

    @Test
    fun largestSubtreeDoesNotContainRoot() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(3, solution.maximumSubtreeSize(edges, intArrayOf(1, 1, 2, 2, 2)))
    }

    @Test
    fun noAdjacentNodesMatch() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))
        assertEquals(1, solution.maximumSubtreeSize(edges, intArrayOf(1, 2, 1, 3)))
    }

    @Test
    fun singleNode() {
        assertEquals(1, solution.maximumSubtreeSize(emptyArray(), intArrayOf(7)))
    }
}
