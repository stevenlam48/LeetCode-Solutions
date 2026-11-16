package findthekthluckynumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheKThLuckyNumberTest {
    @Test
    fun first() {
        assertEquals("4", Solution().kthLuckyNumber(1))
    }

    @Test
    fun second() {
        assertEquals("7", Solution().kthLuckyNumber(2))
    }

    @Test
    fun third() {
        assertEquals("44", Solution().kthLuckyNumber(3))
    }

    @Test
    fun fourth() {
        assertEquals("47", Solution().kthLuckyNumber(4))
    }

    @Test
    fun fifth() {
        assertEquals("74", Solution().kthLuckyNumber(5))
    }

    @Test
    fun tenth() {
        assertEquals("477", Solution().kthLuckyNumber(10))
    }
}
