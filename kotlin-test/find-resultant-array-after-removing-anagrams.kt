package findresultantarrayafterremovinganagrams

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindResultantArrayAfterRemovingAnagramsTest {
    @Test
    fun testExample1() {
        assertEquals(
            listOf("abba", "cd"),
            Solution().removeAnagrams(listOf("abba", "baba", "bbaa", "cd", "cd"))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            listOf("a", "b", "a"),
            Solution().removeAnagrams(listOf("a", "b", "a"))
        )
    }

    @Test
    fun testRepeatedSameWord() {
        assertEquals(
            listOf("b", "a"),
            Solution().removeAnagrams(listOf("b", "b", "b", "a"))
        )
    }

    @Test
    fun testSingleWord() {
        assertEquals(listOf("abc"), Solution().removeAnagrams(listOf("abc")))
    }
}
