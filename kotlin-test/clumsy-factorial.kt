package clumsyfactorial

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClumsyFactorialTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(7, solution.clumsy(4))
    }

    @Test
    fun testExample2() {
        assertEquals(12, solution.clumsy(10))
    }

    @Test
    fun testSmallValues() {
        assertEquals(1, solution.clumsy(1))
        assertEquals(2, solution.clumsy(2))
        assertEquals(6, solution.clumsy(3))
    }

    @Test
    fun testFive() {
        assertEquals(7, solution.clumsy(5))
    }

    @Test
    fun testAllResidues() {
        assertEquals(8, solution.clumsy(6))
        assertEquals(6, solution.clumsy(7))
        assertEquals(9, solution.clumsy(8))
        assertEquals(11, solution.clumsy(9))
    }
}
