package strongpasswordchecker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrongPasswordCheckerTest {
    @Test
    fun `empty password`() {
        assertEquals(6, Solution().strongPasswordChecker(""))
    }

    @Test
    fun `short password needs insertion`() {
        assertEquals(5, Solution().strongPasswordChecker("a"))
    }

    @Test
    fun `valid length with repeat and missing uppercase`() {
        assertEquals(1, Solution().strongPasswordChecker("aaa123"))
    }

    @Test
    fun `already strong`() {
        assertEquals(0, Solution().strongPasswordChecker("1337C0d3"))
    }

    @Test
    fun `long repeated password`() {
        assertEquals(7, Solution().strongPasswordChecker("a".repeat(21)))
    }
}
