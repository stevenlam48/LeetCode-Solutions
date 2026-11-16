package countsubstringsdivisiblebylastdigit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsDivisibleByLastDigitTest {
    private val solution = Solution()

    @Test
    fun `counts standard examples`() {
        assertEquals(7L, solution.countSubstrings("1296"))
        assertEquals(5L, solution.countSubstrings("123"))
    }

    @Test
    fun `counts all suffixes ending in one or two`() {
        assertEquals(3L, solution.countSubstrings("12"))
    }

    @Test
    fun `handles leading zeroes in candidates`() {
        assertEquals(5L, solution.countSubstrings("1008"))
    }

    @Test
    fun `ignores substrings ending in zero`() {
        assertEquals(0L, solution.countSubstrings("0"))
    }

    @Test
    fun `checks divisibility by nine`() {
        assertEquals(3L, solution.countSubstrings("99"))
    }

    @Test
    fun `checks divisibility by four and eight`() {
        assertEquals(3L, solution.countSubstrings("48"))
        assertEquals(1L, solution.countSubstrings("6"))
    }
}
