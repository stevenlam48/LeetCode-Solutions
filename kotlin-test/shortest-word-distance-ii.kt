package shortestworddistanceii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestWordDistanceIiTest {
    @Test
    fun `answers repeated queries`() {
        val wordDistance = WordDistance(listOf("practice", "makes", "perfect", "coding", "makes"))
        assertEquals(3, wordDistance.shortest("coding", "practice"))
        assertEquals(1, wordDistance.shortest("makes", "coding"))
    }

    @Test
    fun `merges sorted occurrence lists`() {
        val wordDistance = WordDistance(listOf("a", "b", "c", "a", "d", "b"))
        assertEquals(1, wordDistance.shortest("a", "d"))
        assertEquals(1, wordDistance.shortest("b", "c"))
    }

    @Test
    fun `returns max value when a word is absent`() {
        val wordDistance = WordDistance(listOf("a", "b"))
        assertEquals(Int.MAX_VALUE, wordDistance.shortest("a", "missing"))
    }
}
