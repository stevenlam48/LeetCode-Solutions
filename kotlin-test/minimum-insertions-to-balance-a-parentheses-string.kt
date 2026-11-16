package minimuminsertionstobalanceaparenthesesstring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumInsertionsToBalanceAParenthesesStringTest {
    private val solution = Solution()

    @Test
    fun oneMissingClosingParenthesis() {
        assertEquals(1, solution.minInsertions("(()))"))
    }

    @Test
    fun singleClosingParenthesisCanPair() {
        assertEquals(0, solution.minInsertions("())"))
    }

    @Test
    fun mixedMissingOpeningAndClosingParentheses() {
        assertEquals(3, solution.minInsertions("))())("))
    }

    @Test
    fun onlyOpeningParentheses() {
        assertEquals(6, solution.minInsertions("((("))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.minInsertions(""))
    }
}
