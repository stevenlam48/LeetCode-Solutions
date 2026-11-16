package makestringasubsequenceusingcyclicincrements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeStringASubsequenceUsingCyclicIncrementsTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().canMakeSubsequence("abc", "ad"))
    }

    @Test
    fun testExample2() {
        assertTrue(Solution().canMakeSubsequence("zc", "ad"))
    }

    @Test
    fun testExample3() {
        assertFalse(Solution().canMakeSubsequence("ab", "d"))
    }

    @Test
    fun testExactMatch() {
        assertTrue(Solution().canMakeSubsequence("abcdef", "abcdef"))
    }

    @Test
    fun testWrapAroundSingleCharacter() {
        assertTrue(Solution().canMakeSubsequence("z", "a"))
    }

    @Test
    fun testTooShort() {
        assertFalse(Solution().canMakeSubsequence("a", "ab"))
    }
}
