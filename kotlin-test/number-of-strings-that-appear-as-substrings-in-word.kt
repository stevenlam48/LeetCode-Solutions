package numberofstringsthatappearassubstringsinword

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfStringsThatAppearAsSubstringsInWordTest {
    @Test
    fun testExample1() {
        assertEquals(
            3,
            Solution().numOfStrings(listOf("a", "abc", "bc", "d"), "abc")
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            2,
            Solution().numOfStrings(listOf("a", "b", "c"), "aaaaabbbbb")
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            3,
            Solution().numOfStrings(listOf("a", "a", "a"), "ab")
        )
    }

    @Test
    fun testNoMatch() {
        assertEquals(
            0,
            Solution().numOfStrings(listOf("x", "y"), "abc")
        )
    }

    @Test
    fun testOverlappingPatterns() {
        assertEquals(
            2,
            Solution().numOfStrings(listOf("ab", "ba"), "aba")
        )
    }
}
