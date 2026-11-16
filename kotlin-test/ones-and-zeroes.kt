package onesandzeroes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OnesAndZeroesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.findMaxForm(listOf("10", "0001", "111001", "1", "0"), 5, 3))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.findMaxForm(listOf("10", "0", "1"), 1, 1))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.findMaxForm(emptyList(), 5, 5))
    }

    @Test
    fun testNoFit() {
        assertEquals(0, solution.findMaxForm(listOf("111", "000"), 1, 1))
    }
}
