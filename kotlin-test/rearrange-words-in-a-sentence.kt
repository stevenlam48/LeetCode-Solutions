package rearrangewordsinasentence

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RearrangeWordsInASentenceTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals("Is cool leetcode", solution.arrangeWords("Leetcode is cool"))
    }

    @Test
    fun testExample2() {
        assertEquals("On and keep calm code", solution.arrangeWords("Keep calm and code on"))
    }

    @Test
    fun testExample3() {
        assertEquals("To be or to be not", solution.arrangeWords("To be or not to be"))
    }

    @Test
    fun testSingleWord() {
        assertEquals("Hello", solution.arrangeWords("Hello"))
    }

    @Test
    fun testStableForEqualLengths() {
        assertEquals("A b c d", solution.arrangeWords("A b c d"))
    }

    @Test
    fun testTwoWords() {
        assertEquals("A bb", solution.arrangeWords("bb a"))
    }
}
