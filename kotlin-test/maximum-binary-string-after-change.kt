package maximumbinarystringafterchange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBinaryStringAfterChangeTest {
    @Test
    fun example() {
        assertEquals("111011", Solution().maximumBinaryString("000110"))
    }

    @Test
    fun alreadyOptimal() {
        assertEquals("01", Solution().maximumBinaryString("01"))
    }

    @Test
    fun singleOne() {
        assertEquals("1", Solution().maximumBinaryString("1"))
    }

    @Test
    fun allZeros() {
        assertEquals("1110", Solution().maximumBinaryString("0000"))
    }

    @Test
    fun leadingOneThenZero() {
        assertEquals("10", Solution().maximumBinaryString("10"))
    }
}
