package makeasquarewiththesamecolor

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MakeASquareWithTheSameColorTest {
    @Test
    fun uniformBlackGridCanMakeSquare() {
        val grid = arrayOf(
            charArrayOf('B', 'B', 'B'),
            charArrayOf('B', 'B', 'B'),
            charArrayOf('B', 'B', 'B')
        )
        assertTrue(Solution().canMakeSquare(grid))
    }

    @Test
    fun threeWhiteCellsNeedOnlyOneChange() {
        val grid = arrayOf(
            charArrayOf('W', 'W', 'B'),
            charArrayOf('W', 'B', 'B'),
            charArrayOf('B', 'B', 'B')
        )
        assertTrue(Solution().canMakeSquare(grid))
    }

    @Test
    fun checkerboardNeedsMoreThanOneChangeInEveryWindow() {
        val grid = arrayOf(
            charArrayOf('B', 'W', 'B'),
            charArrayOf('W', 'B', 'W'),
            charArrayOf('B', 'W', 'B')
        )
        assertFalse(Solution().canMakeSquare(grid))
    }

    @Test
    fun qualifyingWindowMayBeAtBottomRight() {
        val grid = arrayOf(
            charArrayOf('B', 'W', 'B'),
            charArrayOf('W', 'B', 'W'),
            charArrayOf('B', 'W', 'W')
        )
        assertTrue(Solution().canMakeSquare(grid))
    }
}
