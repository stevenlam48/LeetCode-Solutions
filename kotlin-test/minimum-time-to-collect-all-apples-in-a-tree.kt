package minimumtimetocollectallapplesinatree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MinimumTimeToCollectAllApplesInATreeTest {
    private val solution = Solution()

    private val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(0, 2),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
        intArrayOf(2, 3),
        intArrayOf(2, 6)
    )

    @Test
    fun testTwoApples() {
        assertEquals(6, solution.minTime(
            7, edges,
            booleanArrayOf(false, false, true, false, false, true, false)
        ))
    }

    @Test
    fun testSingleApple() {
        assertEquals(2, solution.minTime(
            7, edges,
            booleanArrayOf(false, false, true, false, false, false, false)
        ))
    }

    @Test
    fun testNoApples() {
        assertEquals(0, solution.minTime(
            7, edges,
            booleanArrayOf(false, false, false, false, false, false, false)
        ))
    }

    @Test
    fun testRootAppleOnly() {
        assertEquals(0, solution.minTime(1, emptyArray(), booleanArrayOf(true)))
    }

    @Test
    fun testChain() {
        val chain = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(4, solution.minTime(3, chain, booleanArrayOf(true, false, true)))
    }
}
