package countbinarysubstrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountBinarySubstringsTest {
    @Test
    fun examples() {
        assertEquals(6, Solution().countBinarySubstrings("00110011"))
        assertEquals(4, Solution().countBinarySubstrings("10101"))
    }

    @Test
    fun oneGroup() {
        assertEquals(0, Solution().countBinarySubstrings("000"))
        assertEquals(0, Solution().countBinarySubstrings("0"))
    }

    @Test
    fun empty() {
        assertEquals(0, Solution().countBinarySubstrings(""))
    }
}
