package strongpasswordcheckerii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StrongPasswordCheckerIiTest {
    @Test
    fun `standard strong password`() {
        assertTrue(Solution().strongPasswordCheckerII("IloveLe3tcode!"))
    }

    @Test
    fun `missing digit and adjacent repeats`() {
        assertFalse(Solution().strongPasswordCheckerII("Me+You--IsMyDream"))
    }

    @Test
    fun `too short`() {
        assertFalse(Solution().strongPasswordCheckerII("1aB!"))
    }

    @Test
    fun `adjacent equal characters`() {
        assertFalse(Solution().strongPasswordCheckerII("Aa1!aaaa"))
    }
}
