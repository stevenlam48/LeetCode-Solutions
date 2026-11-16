package nonnegativeintegerswithoutconsecutiveones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NonNegativeIntegersWithoutConsecutiveOnesTest {
    @Test
    fun example1() {
        assertEquals(5, Solution().findIntegers(5))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().findIntegers(1))
    }

    @Test
    fun two() {
        assertEquals(3, Solution().findIntegers(2))
    }

    @Test
    fun zero() {
        assertEquals(1, Solution().findIntegers(0))
    }

    @Test
    fun ten() {
        assertEquals(8, Solution().findIntegers(10))
    }
}
