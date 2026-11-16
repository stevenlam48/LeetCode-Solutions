package smallestabsentpositivegreaterthanaverage

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestAbsentPositiveGreaterThanAverageTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.smallestAbsent(intArrayOf(3, 5)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.smallestAbsent(intArrayOf(-1, 2)))
    }

    @Test
    fun testZeros() {
        assertEquals(1, solution.smallestAbsent(intArrayOf(0, 0)))
    }

    @Test
    fun testAllNegative() {
        assertEquals(1, solution.smallestAbsent(intArrayOf(-3, -2)))
    }

    @Test
    fun testConsecutivePresent() {
        assertEquals(4, solution.smallestAbsent(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(3, solution.smallestAbsent(intArrayOf(2, 2, 2)))
    }
}
