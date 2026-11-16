package weightedwordmapping

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WeightedWordMappingTest {
    private val solution = Solution()

    @Test
    fun uniformWeights() {
        assertEquals("vww", solution.mapWordWeights(listOf("abcd", "def", "xyz"), IntArray(26) { 1 }))
    }

    @Test
    fun periodicWeights() {
        assertEquals("zyvw", solution.mapWordWeights(listOf("a", "b", "z", "abc"), IntArray(26) { it % 7 }))
    }

    @Test
    fun increasingWeights() {
        assertEquals(
            "zf",
            solution.mapWordWeights(listOf("hello", "world"), IntArray(26) { it + 1 })
        )
    }

    @Test
    fun emptyWordsList() {
        assertEquals("", solution.mapWordWeights(emptyList(), IntArray(26)))
    }
}
