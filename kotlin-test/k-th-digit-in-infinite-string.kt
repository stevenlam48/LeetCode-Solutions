package kthdigitininfinitestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KThDigitInInfiniteStringTest {
    @Test
    fun `single digit block is unchanged`() {
        assertEquals(1, Solution().kthDigit(1))
        assertEquals(9, Solution().kthDigit(9))
    }

    @Test
    fun `odd tens complement the final digit`() {
        assertEquals(1, Solution().kthDigit(10))
        assertEquals(9, Solution().kthDigit(11))
        assertEquals(1, Solution().kthDigit(12))
        assertEquals(8, Solution().kthDigit(13))
    }

    @Test
    fun `even tens leave the final digit unchanged`() {
        assertEquals(2, Solution().kthDigit(30))
        assertEquals(0, Solution().kthDigit(31))
    }

    @Test
    fun `crosses into the three digit block`() {
        assertEquals(1, Solution().kthDigit(190))
        assertEquals(0, Solution().kthDigit(191))
        assertEquals(0, Solution().kthDigit(192))
    }

    @Test
    fun `complement also applies in longer numbers`() {
        assertEquals(9, Solution().kthDigit(222))
    }
}
