package detectcyclesin2dgrid

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetectCyclesIn2dGridTest {
    private val solution = Solution()

    @Test
    fun rectangularCycleIsDetected() {
        val grid = arrayOf(
            charArrayOf('a', 'a', 'a', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'a', 'a', 'a')
        )
        assertTrue(solution.containsCycle(grid))
    }

    @Test
    fun anotherRectangularCycleIsDetected() {
        val grid = arrayOf(
            charArrayOf('c', 'c', 'c', 'a'),
            charArrayOf('c', 'd', 'c', 'c'),
            charArrayOf('c', 'c', 'e', 'c'),
            charArrayOf('f', 'c', 'c', 'c')
        )
        assertTrue(solution.containsCycle(grid))
    }

    @Test
    fun differentLettersBreakCycle() {
        val grid = arrayOf(
            charArrayOf('a', 'b', 'b'),
            charArrayOf('b', 'z', 'b'),
            charArrayOf('b', 'b', 'a')
        )
        assertFalse(solution.containsCycle(grid))
    }

    @Test
    fun twoByTwoSameLettersFormCycle() {
        val grid = arrayOf(
            charArrayOf('x', 'x'),
            charArrayOf('x', 'x')
        )
        assertTrue(solution.containsCycle(grid))
    }

    @Test
    fun singleCellHasNoCycle() {
        assertFalse(solution.containsCycle(arrayOf(charArrayOf('a'))))
    }
}
