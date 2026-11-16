package countthenumberofidealarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfIdealArraysTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(10, solution.idealArrays(2, 5))
    }

    @Test
    fun testExample2() {
        assertEquals(11, solution.idealArrays(5, 3))
    }

    @Test
    fun testSingleLength() {
        assertEquals(5, solution.idealArrays(1, 5))
    }

    @Test
    fun testMaxValueOne() {
        assertEquals(1, solution.idealArrays(10, 1))
    }

    @Test
    fun testSmallCase() {
        assertEquals(3, solution.idealArrays(2, 2))
    }
}
