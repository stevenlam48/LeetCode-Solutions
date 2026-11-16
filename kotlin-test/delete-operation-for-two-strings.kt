package deleteoperationfortwostrings

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeleteOperationForTwoStringsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.minDistance("sea", "eat"))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.minDistance("leetcode", "etco"))
    }

    @Test
    fun testEmptyStrings() {
        assertEquals(0, solution.minDistance("", ""))
    }

    @Test
    fun testOneEmpty() {
        assertEquals(3, solution.minDistance("abc", ""))
        assertEquals(3, solution.minDistance("", "abc"))
    }

    @Test
    fun testIdentical() {
        assertEquals(0, solution.minDistance("abc", "abc"))
    }

    @Test
    fun testNoCommonCharacters() {
        assertEquals(4, solution.minDistance("ab", "cd"))
    }
}
