package oddstringdifference

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OddStringDifferenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("abc", solution.oddString(listOf("adc", "wzy", "abc")))
    }

    @Test
    fun testExample2() {
        assertEquals("bob", solution.oddString(listOf("aaa", "bob", "ccc", "ddd")))
    }

    @Test
    fun testOddIsFirst() {
        assertEquals("adc", solution.oddString(listOf("adc", "abc", "def", "ghi")))
    }

    @Test
    fun testTwoWords() {
        assertEquals("aaa", solution.oddString(listOf("aaa", "bob")))
    }
}
