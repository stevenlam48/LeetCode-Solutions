package sumofsquaresofspecialelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SumOfSquaresOfSpecialElementsTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(21, solution.sumOfSquares(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun secondExample() {
        assertEquals(63, solution.sumOfSquares(intArrayOf(2, 7, 1, 19, 18, 3)))
    }

    @Test
    fun singleElement() {
        assertEquals(25, solution.sumOfSquares(intArrayOf(5)))
    }

    @Test
    fun squareLengthCountsMiddleDivisorOnce() {
        assertEquals(3, solution.sumOfSquares(IntArray(9) { 1 }))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.sumOfSquares(intArrayOf()))
    }
}
