package longestuncommonsubsequencei

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestUncommonSubsequenceITest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        assertEquals(3, solution.findLUSlength("aba", "cdc"))
    }

    @Test
    fun testEqualStrings() {
        assertEquals(-1, solution.findLUSlength("aaa", "aaa"))
    }

    @Test
    fun testExampleThree() {
        assertEquals(3, solution.findLUSlength("aaa", "bbb"))
    }

    @Test
    fun testEmptyStrings() {
        assertEquals(-1, solution.findLUSlength("", ""))
    }

    @Test
    fun testOneEmptyString() {
        assertEquals(3, solution.findLUSlength("", "abc"))
    }

    @Test
    fun testDifferentLengths() {
        assertEquals(2, solution.findLUSlength("a", "ab"))
    }
}
