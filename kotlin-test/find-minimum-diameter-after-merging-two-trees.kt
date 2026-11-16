package findminimumdiameteraftermergingtwotrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMinimumDiameterAfterMergingTwoTreesTest {
    @Test
    fun example1() {
        val edges1 = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        val edges2 = arrayOf(intArrayOf(0, 1))
        assertEquals(3, Solution().minimumDiameterAfterMerge(edges1, edges2))
    }

    @Test
    fun example2() {
        val edges1 = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3),
            intArrayOf(2, 4), intArrayOf(2, 5), intArrayOf(3, 6), intArrayOf(2, 7)
        )
        val edges2 = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3),
            intArrayOf(2, 4), intArrayOf(2, 5), intArrayOf(3, 6), intArrayOf(2, 7)
        )
        assertEquals(5, Solution().minimumDiameterAfterMerge(edges1, edges2))
    }

    @Test
    fun bothSingleNodes() {
        assertEquals(1, Solution().minimumDiameterAfterMerge(arrayOf(), arrayOf()))
    }

    @Test
    fun oneSingleNode() {
        assertEquals(2, Solution().minimumDiameterAfterMerge(arrayOf(), arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun twoPaths() {
        val edges1 = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        val edges2 = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(3, Solution().minimumDiameterAfterMerge(edges1, edges2))
    }

    @Test
    fun starAndPath() {
        val edges1 = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(0, 4)
        )
        val edges2 = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(4, Solution().minimumDiameterAfterMerge(edges1, edges2))
    }
}
