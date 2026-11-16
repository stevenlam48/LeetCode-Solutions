package perfectsquares

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PerfectSquaresTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3, solution.numSquares(12))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.numSquares(13))
    }

    @Test
    fun testPerfectSquare() {
        assertEquals(1, solution.numSquares(1))
        assertEquals(1, solution.numSquares(4))
    }

    @Test
    fun testFourSquares() {
        assertEquals(4, solution.numSquares(7))
    }
}
