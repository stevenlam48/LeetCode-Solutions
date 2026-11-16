package greatestenglishletterinupperandlowercase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreatestEnglishLetterInUpperAndLowerCaseTest {
    @Test
    fun `standard examples`() {
        val solution = Solution()
        assertEquals("E", solution.greatestLetter("lEeTcOdE"))
        assertEquals("R", solution.greatestLetter("arRAzFif"))
        assertEquals("", solution.greatestLetter("AbCdEfGhIjK"))
    }

    @Test
    fun `greatest paired letter wins regardless of order`() {
        assertEquals("Z", Solution().greatestLetter("aAbBzZ"))
    }

    @Test
    fun `empty and unmatched letters`() {
        val solution = Solution()
        assertEquals("", solution.greatestLetter(""))
        assertEquals("", solution.greatestLetter("abcXYZ"))
    }
}
