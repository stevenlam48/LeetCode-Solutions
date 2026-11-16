package rearrangespacesbetweenwords

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RearrangeSpacesBetweenWordsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("this   is   a   sentence", solution.reorderSpaces("  this   is  a sentence "))
    }

    @Test
    fun testExample2() {
        assertEquals("practice   makes   perfect ", solution.reorderSpaces(" practice   makes   perfect"))
    }

    @Test
    fun testSingleSpace() {
        assertEquals("hello world", solution.reorderSpaces("hello world"))
    }

    @Test
    fun testSingleWord() {
        assertEquals("hello  ", solution.reorderSpaces("  hello"))
        assertEquals("a", solution.reorderSpaces("a"))
    }

    @Test
    fun testOnlySpaces() {
        assertEquals("   ", solution.reorderSpaces("   "))
    }

    @Test
    fun testTrailingSpaces() {
        assertEquals("a       b", solution.reorderSpaces("a b      "))
    }
}
