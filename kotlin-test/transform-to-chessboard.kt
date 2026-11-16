package transformtochessboard

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TransformToChessboardTest {
    @Test
    fun alreadyValidAndOneSwapExamples() {
        assertEquals(2, Solution().movesToChessboard(arrayOf(
            intArrayOf(0, 1, 1, 0), intArrayOf(0, 1, 1, 0),
            intArrayOf(1, 0, 0, 1), intArrayOf(1, 0, 0, 1))))
        assertEquals(1, Solution().movesToChessboard(arrayOf(
            intArrayOf(0, 1, 0), intArrayOf(1, 0, 1), intArrayOf(1, 0, 1))))
    }

    @Test
    fun twoByTwoExamples() {
        assertEquals(0, Solution().movesToChessboard(arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
        assertEquals(-1, Solution().movesToChessboard(arrayOf(intArrayOf(1, 0), intArrayOf(1, 0))))
    }

    @Test
    fun invalidPatternsReturnMinusOne() {
        assertEquals(-1, Solution().movesToChessboard(arrayOf(intArrayOf(1, 0), intArrayOf(0, 0))))
        assertEquals(-1, Solution().movesToChessboard(arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))))
    }
}
