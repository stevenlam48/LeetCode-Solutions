package countanagrams

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountAnagramsTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(18, solution.countAnagrams("too hot"))
    }

    @Test
    fun testRepeatedLetters() {
        assertEquals(1, solution.countAnagrams("aa"))
    }

    @Test
    fun testSingleWord() {
        assertEquals(24, solution.countAnagrams("abcd"))
    }
}
