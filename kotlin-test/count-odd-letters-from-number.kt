package countoddlettersfromnumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountOddLettersFromNumberTest {
    private val solution = Solution()

    @Test
    fun mixedDigitsExample() {
        assertEquals(5, solution.countOddLetters(123))
    }

    @Test
    fun twoDifferentDigits() {
        assertEquals(4, solution.countOddLetters(12))
    }

    @Test
    fun repeatedWordsCancelAllLetterCounts() {
        assertEquals(0, solution.countOddLetters(11))
        assertEquals(0, solution.countOddLetters(111111))
    }

    @Test
    fun zeroDigitsContributeRepeatedWords() {
        assertEquals(3, solution.countOddLetters(100))
    }

    @Test
    fun zeroMatchesEmptyCppLoop() {
        assertEquals(0, solution.countOddLetters(0))
    }
}
