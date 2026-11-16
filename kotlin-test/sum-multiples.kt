package summultiples

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumMultiplesTest {
    @Test
    fun exampleOne() {
        assertEquals(21, Solution().sumOfMultiples(7))
    }

    @Test
    fun exampleTwo() {
        assertEquals(40, Solution().sumOfMultiples(10))
    }

    @Test
    fun duplicateMultiplesCountedOnce() {
        assertEquals(81, Solution().sumOfMultiples(15))
    }

    @Test
    fun belowEveryAllowedDivisor() {
        assertEquals(0, Solution().sumOfMultiples(1))
        assertEquals(0, Solution().sumOfMultiples(2))
    }
}
