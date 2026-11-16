package stringtransformation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringTransformationTest {
    @Test
    fun `standard rotated target`() {
        assertEquals(2, Solution().numberOfWays("abcd", "cdab", 2))
    }

    @Test
    fun `same target with one operation`() {
        assertEquals(2, Solution().numberOfWays("ababab", "abababab".substring(0, 6), 1))
    }

    @Test
    fun `zero operations keep only original string`() {
        assertEquals(1, Solution().numberOfWays("aaa", "aaa", 0))
    }

    @Test
    fun `target is not a rotation`() {
        assertEquals(0, Solution().numberOfWays("abc", "acb", 5))
    }
}
