package countfancynumbersinarange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountFancyNumbersInARangeTest {
    @Test
    fun singleNumber() {
        assertEquals(1L, Solution().countFancy(1L, 1L))
    }

    @Test
    fun oneDigitRange() {
        assertEquals(9L, Solution().countFancy(1L, 9L))
    }

    @Test
    fun throughTen() {
        assertEquals(10L, Solution().countFancy(1L, 10L))
    }

    @Test
    fun throughHundred() {
        assertEquals(100L, Solution().countFancy(1L, 100L))
    }

    @Test
    fun nonFancyNumbers() {
        assertEquals(0L, Solution().countFancy(119L, 119L))
        assertEquals(0L, Solution().countFancy(155L, 155L))
        assertEquals(0L, Solution().countFancy(209L, 209L))
    }

    @Test
    fun fancyNumbers() {
        assertEquals(1L, Solution().countFancy(128L, 128L))
        assertEquals(2L, Solution().countFancy(99L, 100L))
    }
}
