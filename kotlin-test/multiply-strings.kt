package multiplystrings

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MultiplyStringsTest {
    @Test
    fun example1() {
        assertEquals("6", Solution().multiply("2", "3"))
    }

    @Test
    fun example2() {
        assertEquals("56088", Solution().multiply("123", "456"))
    }

    @Test
    fun zero() {
        assertEquals("0", Solution().multiply("0", "12345"))
        assertEquals("0", Solution().multiply("0", "0"))
    }

    @Test
    fun singleDigits() {
        assertEquals("81", Solution().multiply("9", "9"))
    }

    @Test
    fun largeNumbers() {
        assertEquals("121932631112635269", Solution().multiply("123456789", "987654321"))
    }

    @Test
    fun powerOfTen() {
        assertEquals("1000", Solution().multiply("10", "100"))
    }
}
