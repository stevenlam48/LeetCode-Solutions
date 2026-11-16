package equalizestringsbyaddingorremovingcharactersatends

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EqualizeStringsByAddingOrRemovingCharactersAtEndsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.minOperations("abcde", "cdefgh"))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.minOperations("abc", "ab"))
    }

    @Test
    fun testIdentical() {
        assertEquals(0, solution.minOperations("a", "a"))
        assertEquals(0, solution.minOperations("abcdef", "abcdef"))
    }

    @Test
    fun testNoCommonSubstring() {
        assertEquals(2, solution.minOperations("a", "b"))
        assertEquals(6, solution.minOperations("abc", "def"))
    }

    @Test
    fun testReversed() {
        assertEquals(2, solution.minOperations("ab", "ba"))
    }

    @Test
    fun testSingleCharacterCommon() {
        assertEquals(4, solution.minOperations("abc", "cba"))
    }
}
