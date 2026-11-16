package minimumuniquewordabbreviation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumUniqueWordAbbreviationTest {
    private val solution = Solution()

    @Test
    fun testSingleConflict() {
        assertEquals("a4", solution.minAbbreviation("apple", listOf("blade")))
    }

    @Test
    fun testMultipleConflicts() {
        assertEquals("1p3", solution.minAbbreviation("apple", listOf("blade", "plain", "amber")))
    }

    @Test
    fun testNoSameLengthWord() {
        assertEquals("5", solution.minAbbreviation("apple", listOf("xyz", "toolong")))
    }

    @Test
    fun testEmptyDictionary() {
        assertEquals("3", solution.minAbbreviation("abc", emptyList()))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", solution.minAbbreviation("a", listOf("b")))
    }
}
