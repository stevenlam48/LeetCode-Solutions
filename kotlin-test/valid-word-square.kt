package validwordsquare

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidWordSquareTest {
    private val solution = Solution()

    @Test
    fun acceptsWordSquare() {
        assertTrue(solution.validWordSquare(listOf("abcd", "bnrt", "crmy", "dtye")))
    }

    @Test
    fun rejectsMismatchedSquare() {
        assertFalse(solution.validWordSquare(listOf("ab", "cd")))
    }

    @Test
    fun handlesEmptyAndRaggedInputs() {
        assertTrue(solution.validWordSquare(emptyList()))
        assertTrue(solution.validWordSquare(listOf("a")))
        assertFalse(solution.validWordSquare(listOf("a", "bc")))
    }
}
