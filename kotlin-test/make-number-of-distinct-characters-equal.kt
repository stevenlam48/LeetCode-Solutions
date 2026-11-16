package makenumberofdistinctcharactersequal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeNumberOfDistinctCharactersEqualTest {
    @Test
    fun testExample1() {
        assertFalse(Solution().isItPossible("ac", "b"))
    }

    @Test
    fun testExample2() {
        assertTrue(Solution().isItPossible("ab", "ab"))
    }

    @Test
    fun testExample3() {
        assertFalse(Solution().isItPossible("abc", "b"))
    }

    @Test
    fun testExample4() {
        assertTrue(Solution().isItPossible("abcc", "aab"))
    }

    @Test
    fun testSingleSameCharacter() {
        assertTrue(Solution().isItPossible("a", "a"))
    }

    @Test
    fun testSingleDifferentCharacters() {
        assertTrue(Solution().isItPossible("a", "b"))
    }
}
