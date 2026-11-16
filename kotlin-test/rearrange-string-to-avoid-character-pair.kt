package rearrangestringtoavoidcharacterpair

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RearrangeStringToAvoidCharacterPairTest {
    private val solution = Solution()

    private fun assertNoPair(s: String, x: Char, y: Char) {
        for (i in 0 until s.length - 1) {
            assertFalse(s[i] == x && s[i + 1] == y, "found \"$x$y\" at index $i in \"$s\"")
        }
    }

    @Test
    fun testExample1() {
        val result = solution.rearrangeString("aab", 'a', 'b')
        assertEquals("baa", result)
        assertNoPair(result, 'a', 'b')
    }

    @Test
    fun testExample2() {
        val result = solution.rearrangeString("ab", 'a', 'b')
        assertEquals("ba", result)
        assertNoPair(result, 'a', 'b')
    }

    @Test
    fun testAlreadyValid() {
        val result = solution.rearrangeString("ba", 'a', 'b')
        assertEquals("ba", result)
        assertNoPair(result, 'a', 'b')
    }

    @Test
    fun testInterleaved() {
        val result = solution.rearrangeString("axby", 'a', 'b')
        assertEquals("bxay", result)
        assertNoPair(result, 'a', 'b')
    }

    @Test
    fun testNoOccurrences() {
        assertEquals("xyz", solution.rearrangeString("xyz", 'a', 'b'))
    }

    @Test
    fun testMultipleSwaps() {
        val result = solution.rearrangeString("abab", 'a', 'b')
        assertEquals("bbaa", result)
        assertNoPair(result, 'a', 'b')
    }
}
