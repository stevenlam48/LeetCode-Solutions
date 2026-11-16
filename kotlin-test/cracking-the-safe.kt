package crackingthesafe

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CrackingTheSafeTest {
    @Test
    fun `covers all two passwords of length one`() {
        assertEquals("01", Solution().crackSafe(1, 2))
    }

    @Test
    fun `constructs the primary de bruijn sequence`() {
        assertEquals("10011", Solution().crackSafe(2, 2))
    }

    @Test
    fun `handles a one digit alphabet`() {
        assertEquals("0", Solution().crackSafe(1, 1))
    }

    @Test
    fun `covers every length three binary password exactly once`() {
        val result = Solution().crackSafe(3, 2)
        val expected = (0 until 8).map { Integer.toBinaryString(it).padStart(3, '0') }.toSet()
        assertEquals(10, result.length)
        assertEquals(expected, result.windowed(3).toSet())
    }
}
