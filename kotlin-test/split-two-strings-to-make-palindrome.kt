package splittwostringstomakepalindrome

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SplitTwoStringsToMakePalindromeTest {
    private val solution = Solution()

    @Test
    fun acceptsSingleCharacterStrings() {
        assertTrue(solution.checkPalindromeFormation("x", "y"))
    }

    @Test
    fun rejectsStringsWithoutAValidSplit() {
        assertFalse(solution.checkPalindromeFormation("xbdef", "xecab"))
    }

    @Test
    fun acceptsSplitFromEitherArgumentOrder() {
        assertTrue(solution.checkPalindromeFormation("ulacfd", "jizalu"))
    }

    @Test
    fun acceptsMatchingPalindromicStrings() {
        assertTrue(solution.checkPalindromeFormation("racecar", "racecar"))
    }
}
