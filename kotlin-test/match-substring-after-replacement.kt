package matchsubstringafterreplacement

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MatchSubstringAfterReplacementTest {
    @Test
    fun testExample1() {
        assertTrue(
            Solution().matchReplacement(
                "fool3e7bar",
                "leet",
                arrayOf(charArrayOf('e', '3'), charArrayOf('t', '7'), charArrayOf('t', '8'))
            )
        )
    }

    @Test
    fun testExample2() {
        assertFalse(
            Solution().matchReplacement(
                "fooleetbar",
                "f00l",
                arrayOf(charArrayOf('o', '0'))
            )
        )
    }

    @Test
    fun testExample3() {
        assertTrue(
            Solution().matchReplacement(
                "Fool33tbaR",
                "leetd",
                arrayOf(
                    charArrayOf('e', '3'),
                    charArrayOf('t', '7'),
                    charArrayOf('t', '8'),
                    charArrayOf('d', 'b'),
                    charArrayOf('p', 'b')
                )
            )
        )
    }

    @Test
    fun testExactMatch() {
        assertTrue(Solution().matchReplacement("abc", "abc", arrayOf()))
    }

    @Test
    fun testSubLongerThanString() {
        assertFalse(Solution().matchReplacement("ab", "abc", arrayOf()))
    }

    @Test
    fun testDigitMapping() {
        assertTrue(
            Solution().matchReplacement(
                "a1c",
                "abc",
                arrayOf(charArrayOf('b', '1'))
            )
        )
    }
}
