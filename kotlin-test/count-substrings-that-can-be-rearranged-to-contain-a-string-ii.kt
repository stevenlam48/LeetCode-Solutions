package countsubstringsthatcanberearrangedtocontainastringii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsThatCanBeRearrangedToContainAStringIiTest {
    private val solution = Solution()

    @Test
    fun `counts standard examples`() {
        assertEquals(1L, solution.validSubstringCount("bcca", "abc"))
        assertEquals(10L, solution.validSubstringCount("abcabc", "abc"))
    }

    @Test
    fun `returns zero when required characters are missing`() {
        assertEquals(0L, solution.validSubstringCount("abc", "abcd"))
    }

    @Test
    fun `handles repeated required characters`() {
        assertEquals(3L, solution.validSubstringCount("aaa", "aa"))
    }

    @Test
    fun `handles a single character target`() {
        assertEquals(2L, solution.validSubstringCount("ab", "b"))
    }

    @Test
    fun `handles an empty source`() {
        assertEquals(0L, solution.validSubstringCount("", "a"))
    }
}
