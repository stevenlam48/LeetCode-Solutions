package findspecialsubstringoflengthk

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindSpecialSubstringOfLengthKTest {
    @Test
    fun testExample1() {
        assertTrue(Solution().hasSpecialSubstring("aaabaaa", 3))
    }

    @Test
    fun testExample2() {
        assertFalse(Solution().hasSpecialSubstring("abc", 2))
    }

    @Test
    fun testExample3() {
        assertTrue(Solution().hasSpecialSubstring("a", 1))
    }

    @Test
    fun testRunTooLong() {
        assertFalse(Solution().hasSpecialSubstring("aaaa", 3))
    }

    @Test
    fun testNoRunOfLength() {
        assertFalse(Solution().hasSpecialSubstring("aaabaaa", 2))
    }

    @Test
    fun testWholeString() {
        assertTrue(Solution().hasSpecialSubstring("zzzzz", 5))
    }
}
