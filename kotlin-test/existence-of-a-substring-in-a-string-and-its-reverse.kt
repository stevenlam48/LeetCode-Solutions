package existenceofasubstringinastringanditsreverse

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ExistenceOfASubstringInAStringAndItsReverseTest {
    @Test
    fun reversedPairOccursLater() {
        assertTrue(Solution().isSubstringPresent("leetcode"))
    }

    @Test
    fun reversedPairSurroundsMiddleCharacter() {
        assertTrue(Solution().isSubstringPresent("abcba"))
    }

    @Test
    fun noReversedPair() {
        assertFalse(Solution().isSubstringPresent("abcd"))
    }

    @Test
    fun repeatedPairIsItsOwnReverse() {
        assertTrue(Solution().isSubstringPresent("aa"))
    }

    @Test
    fun stringsShorterThanTwoCharacters() {
        val solution = Solution()
        assertFalse(solution.isSubstringPresent(""))
        assertFalse(solution.isSubstringPresent("a"))
    }
}
