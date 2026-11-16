package distinctechosubstrings

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DistinctEchoSubstringsTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().distinctEchoSubstrings("abcabcabc"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().distinctEchoSubstrings("leetcodeleetcode"))
    }

    @Test
    fun testRepeatedChar() {
        assertEquals(2, Solution().distinctEchoSubstrings("aaaa"))
    }

    @Test
    fun testNoEcho() {
        assertEquals(0, Solution().distinctEchoSubstrings("abc"))
        assertEquals(0, Solution().distinctEchoSubstrings("a"))
    }

    @Test
    fun testSimpleEcho() {
        assertEquals(1, Solution().distinctEchoSubstrings("abab"))
    }
}
