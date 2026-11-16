package isomorphicstrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IsomorphicStringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.isIsomorphic("egg", "add"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.isIsomorphic("foo", "bar"))
    }

    @Test
    fun testExample3() {
        assertTrue(solution.isIsomorphic("paper", "title"))
    }

    @Test
    fun testDifferentLengths() {
        assertFalse(solution.isIsomorphic("ab", "abc"))
    }

    @Test
    fun testEmptyStrings() {
        assertTrue(solution.isIsomorphic("", ""))
    }

    @Test
    fun testManyToOneMapping() {
        assertFalse(solution.isIsomorphic("badc", "baba"))
    }
}
