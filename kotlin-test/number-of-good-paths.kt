package numberofgoodpaths

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfGoodPathsTest {
    @Test
    fun testExample1() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3), intArrayOf(2, 4)
        )
        assertEquals(6, Solution().numberOfGoodPaths(intArrayOf(1, 3, 2, 1, 3), edges))
    }

    @Test
    fun testExample2() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(2, 4)
        )
        assertEquals(7, Solution().numberOfGoodPaths(intArrayOf(1, 1, 2, 2, 3), edges))
    }

    @Test
    fun testSingleNode() {
        assertEquals(1, Solution().numberOfGoodPaths(intArrayOf(1), emptyArray()))
    }

    @Test
    fun testTwoEqualNodes() {
        assertEquals(3, Solution().numberOfGoodPaths(intArrayOf(1, 1), arrayOf(intArrayOf(0, 1))))
    }
}
