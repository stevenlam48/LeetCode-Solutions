package detectsquares

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DetectSquaresTest {
    @Test
    fun leetCodeOperationSequence() {
        val detectSquares = DetectSquares()
        detectSquares.add(intArrayOf(3, 10))
        detectSquares.add(intArrayOf(11, 2))
        detectSquares.add(intArrayOf(3, 2))
        assertEquals(1, detectSquares.count(intArrayOf(11, 10)))
        detectSquares.add(intArrayOf(14, 8))
        detectSquares.add(intArrayOf(11, 2))
        assertEquals(2, detectSquares.count(intArrayOf(11, 10)))
    }

    @Test
    fun duplicatePointsMultiplySquareCount() {
        val detectSquares = DetectSquares()
        repeat(2) { detectSquares.add(intArrayOf(0, 0)) }
        repeat(2) { detectSquares.add(intArrayOf(1, 0)) }
        repeat(2) { detectSquares.add(intArrayOf(0, 1)) }
        repeat(2) { detectSquares.add(intArrayOf(1, 1)) }
        assertEquals(8, detectSquares.count(intArrayOf(0, 0)))
    }

    @Test
    fun emptyAndDegenerateConfigurationsReturnZero() {
        val detectSquares = DetectSquares()
        assertEquals(0, detectSquares.count(intArrayOf(0, 0)))
        detectSquares.add(intArrayOf(0, 0))
        detectSquares.add(intArrayOf(0, 1))
        detectSquares.add(intArrayOf(1, 0))
        assertEquals(0, detectSquares.count(intArrayOf(0, 0)))
    }
}
