package palindromePartition

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PalindromePartitionTest {
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
        val result = Solution().partition("a")
        assertEquals(setOf(listOf("a")), setOfPartitions(result))
    }

    @Test
    fun testAba() {
        val result = Solution().partition("aba")
        assertEquals(
            setOf(
                listOf("a", "b", "a"),
                listOf("aba")
            ),
            setOfPartitions(result)
        )
    }

    @Test
    fun testAllSameCharacters() {
        val result = Solution().partition("aaa")
        assertEquals(
            setOf(
                listOf("a", "a", "a"),
                listOf("a", "aa"),
                listOf("aa", "a"),
                listOf("aaa")
            ),
            setOfPartitions(result)
        )
    }

    @Test
    fun testNoMultiCharacterPalindrome() {
        val result = Solution().partition("abc")
        assertEquals(setOf(listOf("a", "b", "c")), setOfPartitions(result))
    }
}
