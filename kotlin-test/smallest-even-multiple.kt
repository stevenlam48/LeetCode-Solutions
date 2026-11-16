package smallestevenmultiple

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestEvenMultipleTest {
    private val solution = Solution()

    @Test
    fun testOdd() {
        assertEquals(10, solution.smallestEvenMultiple(5))
    }

    @Test
    fun testEven() {
        assertEquals(6, solution.smallestEvenMultiple(6))
    }

    @Test
    fun testOne() {
        assertEquals(2, solution.smallestEvenMultiple(1))
    }

    @Test
    fun testTwo() {
        assertEquals(2, solution.smallestEvenMultiple(2))
    }

    @Test
    fun testThree() {
        assertEquals(6, solution.smallestEvenMultiple(3))
    }
}
