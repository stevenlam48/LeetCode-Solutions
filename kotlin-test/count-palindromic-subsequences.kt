package countpalindromicsubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountPalindromicSubsequencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2, solution.countPalindromes("103301"))
    }

    @Test
    fun testExample2() {
        assertEquals(21, solution.countPalindromes("0000000"))
    }

    @Test
    fun testExample3() {
        assertEquals(2, solution.countPalindromes("9999900000"))
    }

    @Test
    fun testTooShort() {
        assertEquals(0, solution.countPalindromes("1"))
        assertEquals(0, solution.countPalindromes("1234"))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.countPalindromes(""))
    }
}
