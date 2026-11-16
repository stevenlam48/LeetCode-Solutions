package maximumoddbinarynumber

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumOddBinaryNumberTest {
    @Test
    fun examples() {
        assertEquals("001", Solution().maximumOddBinaryNumber("010"))
        assertEquals("1001", Solution().maximumOddBinaryNumber("0101"))
    }

    @Test
    fun singleOne() {
        assertEquals("1", Solution().maximumOddBinaryNumber("1"))
    }

    @Test
    fun allOnesRemainUnchanged() {
        assertEquals("1111", Solution().maximumOddBinaryNumber("1111"))
    }

    @Test
    fun movesOneFromInteriorToEnd() {
        assertEquals("11001", Solution().maximumOddBinaryNumber("01110"))
    }
}
