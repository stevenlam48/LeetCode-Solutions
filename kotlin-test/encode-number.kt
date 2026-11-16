package encodenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EncodeNumberTest {
    private val solution = Solution()

    @Test
    fun zeroEncodesToEmptyString() {
        assertEquals("", solution.encode(0))
    }

    @Test
    fun encodesSingleDigitValues() {
        assertEquals("0", solution.encode(1))
        assertEquals("1", solution.encode(2))
    }

    @Test
    fun encodesConsecutiveValues() {
        assertEquals("00", solution.encode(3))
        assertEquals("01", solution.encode(4))
        assertEquals("10", solution.encode(5))
        assertEquals("11", solution.encode(6))
    }

    @Test
    fun encodingGrowsAfterEachPowerOfTwo() {
        assertEquals("000", solution.encode(7))
        assertEquals("001", solution.encode(8))
        assertEquals("011", solution.encode(10))
    }
}
