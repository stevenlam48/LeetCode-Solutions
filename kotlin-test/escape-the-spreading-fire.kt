package escapethespreadingfire

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EscapeTheSpreadingFireTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 2, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 2, 2, 1, 0),
            intArrayOf(0, 2, 0, 0, 1, 2, 0),
            intArrayOf(0, 0, 2, 2, 2, 0, 2),
            intArrayOf(0, 0, 0, 0, 0, 0, 0)
        )
        assertEquals(3, solution.maximumMinutes(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 1, 2, 0),
            intArrayOf(0, 2, 0, 0)
        )
        assertEquals(-1, solution.maximumMinutes(grid))
    }

    @Test
    fun testNoFire() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(1000000000, solution.maximumMinutes(grid))
    }

    @Test
    fun testTargetIsWall() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 2)
        )
        assertEquals(-1, solution.maximumMinutes(grid))
    }

    @Test
    fun testPersonTrapped() {
        val grid = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(2, 0)
        )
        assertEquals(-1, solution.maximumMinutes(grid))
    }
}
