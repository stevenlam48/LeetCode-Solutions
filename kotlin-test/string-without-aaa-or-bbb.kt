package stringwithoutaaaorbbb

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class StringWithoutAaaOrBbbTest {
    @Test
    fun `one a and two b characters`() {
        assertEquals("bab", Solution().strWithout3a3b(1, 2))
    }

    @Test
    fun `balanced larger counts`() {
        val result = Solution().strWithout3a3b(4, 2)
        assertEquals(6, result.length)
        assertEquals(4, result.count { it == 'a' })
        assertEquals(2, result.count { it == 'b' })
        assertFalse(result.contains("aaa"))
        assertFalse(result.contains("bbb"))
    }

    @Test
    fun `equal counts`() {
        assertEquals("ababab", Solution().strWithout3a3b(3, 3))
    }

    @Test
    fun `zero counts`() {
        assertEquals("", Solution().strWithout3a3b(0, 0))
    }
}
