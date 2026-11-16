package stringmatchinginanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringMatchingInAnArrayTest {
    @Test
    fun `standard substrings`() {
        val result = Solution().stringMatching(listOf("mass", "as", "hero", "superhero"))
        assertEquals(setOf("as", "hero"), result.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun `substrings in longer words`() {
        val result = Solution().stringMatching(listOf("leetcode", "et", "code"))
        assertEquals(setOf("et", "code"), result.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun `no matches`() {
        assertEquals(emptyList<String>(), Solution().stringMatching(listOf("blue", "green", "bu")))
    }

    @Test
    fun `duplicates match each other`() {
        assertEquals(listOf("a", "a"), Solution().stringMatching(listOf("a", "a")))
    }
}
