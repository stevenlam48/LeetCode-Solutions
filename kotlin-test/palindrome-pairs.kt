package palindromepairs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromePairsTest {
    private val solution = Solution()

    @Test
    fun exampleWithDifferentLengths() {
        val result = solution.palindromePairs(arrayOf("abcd", "dcba", "lls", "s", "sssll"))
        assertEquals(
            setOf(listOf(0, 1), listOf(1, 0), listOf(3, 2), listOf(2, 4)),
            result.map { it.toList() }.toSet()
        )
        assertEquals(4, result.size)
    }

    @Test
    fun reversedWords() {
        val result = solution.palindromePairs(arrayOf("bat", "tab", "cat"))
        assertEquals(setOf(listOf(0, 1), listOf(1, 0)), result.map { it.toList() }.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun emptyWordPairsWithPalindromes() {
        val result = solution.palindromePairs(arrayOf("a", ""))
        assertEquals(setOf(listOf(0, 1), listOf(1, 0)), result.map { it.toList() }.toSet())
        assertEquals(2, result.size)
    }

    @Test
    fun noPairs() {
        assertTrue(solution.palindromePairs(arrayOf("abc", "de")).isEmpty())
        assertTrue(solution.palindromePairs(emptyArray()).isEmpty())
    }
}
