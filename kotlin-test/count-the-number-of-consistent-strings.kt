package countthenumberofconsistentstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CountTheNumberOfConsistentStringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(
            2,
            solution.countConsistentStrings("ab", arrayOf("ad", "bd", "aaab", "baa", "badab"))
        )
    }

    @Test
    fun testExample2() {
        assertEquals(
            7,
            solution.countConsistentStrings("abc", arrayOf("a", "b", "c", "ab", "ac", "bc", "abc"))
        )
    }

    @Test
    fun testExample3() {
        assertEquals(
            3,
            solution.countConsistentStrings("cad", arrayOf("a", "b", "c", "d"))
        )
    }

    @Test
    fun testEmptyWords() {
        assertEquals(0, solution.countConsistentStrings("abc", arrayOf()))
    }

    @Test
    fun testAllConsistent() {
        assertEquals(2, solution.countConsistentStrings("abc", arrayOf("abc", "aabbcc")))
    }
}
