package sumofdigitsinbasek

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfDigitsInBaseKTest {
    @Test
    fun exampleOne() {
        assertEquals(9, Solution().sumBase(34, 6))
    }

    @Test
    fun baseTen() {
        assertEquals(1, Solution().sumBase(10, 10))
    }

    @Test
    fun singleDigit() {
        assertEquals(1, Solution().sumBase(1, 2))
        assertEquals(0, Solution().sumBase(0, 7))
    }
}
