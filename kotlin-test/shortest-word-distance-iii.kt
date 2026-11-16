package shortestworddistanceiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestWordDistanceIiiTest {
    private val solution = Solution()

    @Test
    fun `different words`() {
        val words = listOf("practice", "makes", "perfect", "coding", "makes")
        assertEquals(1, solution.shortestWordDistance(words, "makes", "coding"))
    }

    @Test
    fun `same words use two distinct occurrences`() {
        val words = listOf("practice", "makes", "perfect", "coding", "makes")
        assertEquals(3, solution.shortestWordDistance(words, "makes", "makes"))
    }

    @Test
    fun `adjacent repeated words`() {
        assertEquals(1, solution.shortestWordDistance(listOf("a", "a", "b", "a"), "a", "a"))
    }

    @Test
    fun `different words may precede each other`() {
        assertEquals(1, solution.shortestWordDistance(listOf("a", "b", "c", "a", "b"), "b", "c"))
    }
}
