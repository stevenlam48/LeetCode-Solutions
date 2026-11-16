package stringtointegeratoi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringToIntegerAtoiTest {
    @Test
    fun `standard positive number`() {
        assertEquals(42, Solution().myAtoi("42"))
    }

    @Test
    fun `whitespace and negative sign`() {
        assertEquals(-42, Solution().myAtoi(" \t -42"))
    }

    @Test
    fun `stops at first nondigit`() {
        assertEquals(4193, Solution().myAtoi("4193 with words"))
    }

    @Test
    fun `clamps positive overflow`() {
        assertEquals(Int.MAX_VALUE, Solution().myAtoi("2147483648"))
    }

    @Test
    fun `clamps negative overflow`() {
        assertEquals(Int.MIN_VALUE, Solution().myAtoi("-2147483649"))
    }

    @Test
    fun `whitespace only`() {
        assertEquals(0, Solution().myAtoi(" \t "))
    }
}
