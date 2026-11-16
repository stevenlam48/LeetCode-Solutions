package solvetheequation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SolveTheEquationTest {
    @Test
    fun example1() {
        assertEquals("x=2", Solution().solveEquation("x+5-3+x=6+x-2"))
    }

    @Test
    fun infiniteSolutions() {
        assertEquals("Infinite solutions", Solution().solveEquation("x=x"))
    }

    @Test
    fun zeroSolution() {
        assertEquals("x=0", Solution().solveEquation("2x=x"))
    }

    @Test
    fun negativeSolution() {
        assertEquals("x=-4", Solution().solveEquation("x+1=2x+5"))
    }

    @Test
    fun coefficientOnBothSides() {
        assertEquals("x=3", Solution().solveEquation("3x=9"))
    }

    @Test
    fun noSolution() {
        assertEquals("No solution", Solution().solveEquation("x=x+1"))
    }

    @Test
    fun negativeLeadingCoefficient() {
        assertEquals("x=-1", Solution().solveEquation("-x=1"))
    }
}
