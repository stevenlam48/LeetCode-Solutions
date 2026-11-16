package palindromepermutationii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PalindromePermutationIiTest {
    private val solution = Solution()

    @Test
    fun examples() {
        assertEquals(listOf("abba", "baab"), solution.generatePalindromes("aabb"))
        assertEquals(listOf("civic", "icvci"), solution.generatePalindromes("civic"))
    }

    @Test
    fun oddLength() {
        assertEquals(listOf("aba"), solution.generatePalindromes("aab"))
        assertEquals(listOf("aaa"), solution.generatePalindromes("aaa"))
    }

    @Test
    fun impossible() {
        assertTrue(solution.generatePalindromes("abc").isEmpty())
        assertTrue(solution.generatePalindromes("aabbcd").isEmpty())
    }

    @Test
    fun emptyInput() {
        assertTrue(solution.generatePalindromes("").isEmpty())
    }
}
