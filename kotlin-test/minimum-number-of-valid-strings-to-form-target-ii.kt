package minimumnumberofvalidstringstoformtargetii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfValidStringsToFormTargetIITest {
    private val solution = Solution()

    @Test
    fun combinesPrefixesFromDifferentWords() {
        assertEquals(
            3,
            solution.minValidStrings(listOf("abc", "aaaaa", "bcdef"), "aabcdabc")
        )
    }

    @Test
    fun reusesAWordPrefix() {
        assertEquals(2, solution.minValidStrings(listOf("abababab", "ab"), "ababaababa"))
    }

    @Test
    fun targetCannotBeFormed() {
        assertEquals(-1, solution.minValidStrings(listOf("abcdef"), "xyz"))
    }

    @Test
    fun singleCharacterPrefixes() {
        assertEquals(3, solution.minValidStrings(listOf("z"), "zzz"))
    }

    @Test
    fun emptyTarget() {
        assertEquals(0, solution.minValidStrings(emptyList(), ""))
    }
}
