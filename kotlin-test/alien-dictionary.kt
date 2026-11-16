package aliendictionary

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AlienDictionaryTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals("wertf", solution.alienOrder(listOf("wrt", "wrf", "er", "ett", "rftt")))
    }

    @Test
    fun secondExample() {
        assertEquals("zx", solution.alienOrder(listOf("z", "x")))
    }

    @Test
    fun cycleHasNoValidOrder() {
        assertEquals("", solution.alienOrder(listOf("z", "x", "z")))
    }

    @Test
    fun invalidPrefixOrder() {
        assertEquals("", solution.alienOrder(listOf("abc", "ab")))
    }

    @Test
    fun repeatedSingleWordIncludesEveryCharacter() {
        val result = solution.alienOrder(listOf("abc", "abc"))
        assertEquals(3, result.length)
        assertEquals(setOf('a', 'b', 'c'), result.toSet())
    }

    @Test
    fun emptyInput() {
        assertEquals("", solution.alienOrder(emptyList()))
    }
}
