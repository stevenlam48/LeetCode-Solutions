package palindromePartition2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PalindromePartition2Test {
    private fun setOfPartitions(result: List<List<String>>): Set<List<String>> =
        result.map { it.toList() }.toSet()

    @Test
    fun testExampleAab() {
        val result = Solution().partition("aab")
        assertEquals(
            setOf(
                listOf("a", "a", "b"),
                listOf("aa", "b")
            ),
            setOfPartitions(result)
        )
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(setOf(listOf("a")), setOfPartitions(Solution().partition("a")))
    }

    @Test
    fun testAba() {
        assertEquals(
            setOf(
                listOf("a", "b", "a"),
                listOf("aba")
            ),
            setOfPartitions(Solution().partition("aba"))
        )
    }

    @Test
    fun testAllSameCharacters() {
        assertEquals(
            setOf(
                listOf("a", "a", "a"),
                listOf("a", "aa"),
                listOf("aa", "a"),
                listOf("aaa")
            ),
            setOfPartitions(Solution().partition("aaa"))
        )
    }

    @Test
    fun testNoMultiCharacterPalindrome() {
        assertEquals(setOf(listOf("a", "b", "c")), setOfPartitions(Solution().partition("abc")))
    }

    @Test
    fun testTwoDistinctCharacters() {
        assertEquals(setOf(listOf("a", "b")), setOfPartitions(Solution().partition("ab")))
    }
}
