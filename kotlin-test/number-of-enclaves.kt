package numberofenclaves

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfEnclavesTest {
    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(1, 0, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0)
        )
        assertEquals(3, Solution().numEnclaves(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 1, 0),
            intArrayOf(0, 0, 0, 0)
        )
        assertEquals(0, Solution().numEnclaves(grid))
    }

    @Test
    fun testSingleEnclosedCell() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(1, Solution().numEnclaves(grid))
    }

    @Test
    fun testSingleBoundaryCell() {
        assertEquals(0, Solution().numEnclaves(arrayOf(intArrayOf(1))))
    }
}
