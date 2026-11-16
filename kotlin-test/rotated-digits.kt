package rotateddigits

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotatedDigitsTest {
    @Test
    fun leetCodeExampleTen() {
        assertEquals(4, Solution().rotatedDigits(10))
    }

    @Test
    fun zero() {
        assertEquals(0, Solution().rotatedDigits(0))
    }

    @Test
    fun one() {
        assertEquals(0, Solution().rotatedDigits(1))
    }

    @Test
    fun two() {
        assertEquals(1, Solution().rotatedDigits(2))
    }

    @Test
    fun nine() {
        assertEquals(4, Solution().rotatedDigits(9))
    }

    @Test
    fun twenty() {
        assertEquals(9, Solution().rotatedDigits(20))
    }

    @Test
    fun leetCodeExampleEightHundredFiftySeven() {
        assertEquals(247, Solution().rotatedDigits(857))
    }
}
