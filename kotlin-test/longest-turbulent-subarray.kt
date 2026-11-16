package longestturbulentsubarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestTurbulentSubarrayTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(5, solution.maxTurbulenceSize(intArrayOf(9, 4, 2, 10, 7, 8, 8, 1, 9)))
    }

    @Test
    fun testExampleTwo() {
        assertEquals(2, solution.maxTurbulenceSize(intArrayOf(4, 8, 12, 16)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, solution.maxTurbulenceSize(intArrayOf(100)))
    }

    @Test
    fun testAllEqual() {
        assertEquals(2, solution.maxTurbulenceSize(intArrayOf(100, 100, 100)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(2, solution.maxTurbulenceSize(intArrayOf(1, 2)))
    }

    @Test
    fun testFullyTurbulent() {
        assertEquals(6, solution.maxTurbulenceSize(intArrayOf(1, 3, 2, 4, 3, 5)))
    }
}
