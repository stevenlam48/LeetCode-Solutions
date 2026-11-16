package maximumsubstringswithdistinctstart

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubstringsWithDistinctStartTest {
    private val solution = Solution()

    @Test
    fun duplicateStartingLettersAreIgnored() {
        assertEquals(3, solution.maxDistinct("abacaba"))
    }

    @Test
    fun everyLetterIsDistinct() {
        assertEquals(3, solution.maxDistinct("abc"))
    }

    @Test
    fun oneRepeatedLetter() {
        assertEquals(1, solution.maxDistinct("aaaaaa"))
    }

    @Test
    fun emptyString() {
        assertEquals(0, solution.maxDistinct(""))
    }

    @Test
    fun allLowercaseLetters() {
        assertEquals(26, solution.maxDistinct("zyxwvutsrqponmlkjihgfedcba"))
    }
}
