package removepalindromicsubsequences

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovePalindromicSubsequencesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.removePalindromeSub("ababa"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.removePalindromeSub("abb"))
    }

    @Test
    fun testExample3() {
        assertEquals(2, solution.removePalindromeSub("baabb"))
    }

    @Test
    fun testEmptyString() {
        assertEquals(0, solution.removePalindromeSub(""))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(1, solution.removePalindromeSub("a"))
    }
}
