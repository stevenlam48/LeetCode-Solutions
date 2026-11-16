package findasafewalkthroughagrid

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindASafeWalkThroughAGridTest {
    @Test
    fun example1() {
        val grid = arrayOf(
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(0, 1, 0, 1, 0),
            intArrayOf(0, 0, 0, 1, 0)
        )
        assertTrue(Solution().findSafeWalk(grid, 1))
    }

    @Test
    fun example3() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        assertTrue(Solution().findSafeWalk(grid, 5))
    }

    @Test
    fun singleEmptyCell() {
        assertTrue(Solution().findSafeWalk(arrayOf(intArrayOf(0)), 1))
    }

    @Test
    fun singleDangerousCellWithInsufficientHealth() {
        assertFalse(Solution().findSafeWalk(arrayOf(intArrayOf(1)), 1))
    }

    @Test
    fun singleDangerousCellWithEnoughHealth() {
        assertTrue(Solution().findSafeWalk(arrayOf(intArrayOf(1)), 2))
    }

    @Test
    fun allEmptyGrid() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        assertTrue(Solution().findSafeWalk(grid, 1))
    }
}
