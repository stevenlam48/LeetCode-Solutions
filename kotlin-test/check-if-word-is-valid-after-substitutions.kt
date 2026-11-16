package checkifwordisvalidaftersubstitutions

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfWordIsValidAfterSubstitutionsTest {
    private val solution = Solution()

    @Test
    fun testValidNestedSubstitutions() {
        assertTrue(solution.isValid("aabcbc"))
    }

    @Test
    fun testLongValidString() {
        assertTrue(solution.isValid("abcabcababcc"))
    }

    @Test
    fun testInvalidOrder() {
        assertFalse(solution.isValid("abccba"))
    }

    @Test
    fun testInvalidStart() {
        assertFalse(solution.isValid("cababc"))
    }

    @Test
    fun testSingleCharacter() {
        assertFalse(solution.isValid("a"))
    }

    @Test
    fun testEmptyString() {
        assertTrue(solution.isValid(""))
    }
}
