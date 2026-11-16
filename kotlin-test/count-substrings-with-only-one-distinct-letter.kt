package countsubstringswithonlyonedistinctletter

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountSubstringsWithOnlyOneDistinctLetterTest {
    private val solution = Solution()

    @Test
    fun `counts standard example`() {
        assertEquals(12, solution.countLetters("aaabbb"))
    }

    @Test
    fun `counts a single run`() {
        assertEquals(10, solution.countLetters("aaaa"))
    }

    @Test
    fun `counts every character separately when adjacent characters differ`() {
        assertEquals(2, solution.countLetters("ab"))
    }

    @Test
    fun `handles empty and single character inputs`() {
        assertEquals(0, solution.countLetters(""))
        assertEquals(1, solution.countLetters("a"))
    }
}
