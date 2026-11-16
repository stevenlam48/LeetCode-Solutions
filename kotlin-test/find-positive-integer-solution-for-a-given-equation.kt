package findpositiveintegersolutionforagivenequation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPositiveIntegerSolutionForAGivenEquationTest {
    @Test
    fun testSumFunction() {
        val f = CustomFunction { x, y -> x + y }
        assertEquals(
            listOf(listOf(1, 4), listOf(2, 3), listOf(3, 2), listOf(4, 1)),
            Solution().findSolution(f, 5)
        )
    }

    @Test
    fun testProductFunction() {
        val f = CustomFunction { x, y -> x * y }
        assertEquals(
            listOf(listOf(1, 4), listOf(2, 2), listOf(4, 1)),
            Solution().findSolution(f, 4)
        )
    }

    @Test
    fun testNoSolution() {
        val f = CustomFunction { x, y -> x * 1000 + y }
        assertEquals(emptyList<List<Int>>(), Solution().findSolution(f, 1))
    }

    @Test
    fun testSingleSolution() {
        val f = CustomFunction { x, y -> x + y }
        assertEquals(listOf(listOf(1, 1)), Solution().findSolution(f, 2))
    }
}
