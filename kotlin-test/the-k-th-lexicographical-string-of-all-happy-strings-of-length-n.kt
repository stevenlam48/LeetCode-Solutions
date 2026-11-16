package thekthlexicographicalstringofallhappystringsoflengthn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheKThLexicographicalStringOfAllHappyStringsOfLengthNTest {

    @Test
    fun testExample1() {
        assertEquals("c", Solution().getHappyString(1, 3))
    }

    @Test
    fun testExample2() {
        assertEquals("", Solution().getHappyString(1, 4))
    }

    @Test
    fun testExample3() {
        assertEquals("cab", Solution().getHappyString(3, 9))
    }

    @Test
    fun testFirstHappyString() {
        assertEquals("aba", Solution().getHappyString(3, 1))
    }

    @Test
    fun testOutOfRange() {
        assertEquals("", Solution().getHappyString(2, 7))
    }

    @Test
    fun testLastHappyString() {
        assertEquals("cbc", Solution().getHappyString(3, 12))
    }
}
