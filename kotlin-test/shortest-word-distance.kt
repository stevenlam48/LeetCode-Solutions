package shortestworddistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestWordDistanceTest {
    private val solution = Solution()

    @Test
    fun `nonadjacent words`() {
        val words = listOf("practice", "makes", "perfect", "coding", "makes")
        assertEquals(3, solution.shortestDistance(words, "coding", "practice"))
        assertEquals(1, solution.shortestDistance(words, "makes", "coding"))
    }

    @Test
    fun `updates nearest prior occurrence`() {
        val words = listOf("a", "b", "a", "a", "b")
        assertEquals(1, solution.shortestDistance(words, "a", "b"))
    }

    @Test
    fun `finds reversed word order`() {
        assertEquals(2, solution.shortestDistance(listOf("x", "y", "z", "w"), "w", "y"))
    }
}
