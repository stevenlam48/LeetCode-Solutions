package strobogrammaticnumber

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StrobogrammaticNumberTest {
    @Test
    fun `sixty nine rotates to itself`() {
        assertTrue(Solution().isStrobogrammatic("69"))
    }

    @Test
    fun `eighty eight rotates to itself`() {
        assertTrue(Solution().isStrobogrammatic("88"))
    }

    @Test
    fun `non rotatable digit fails`() {
        assertFalse(Solution().isStrobogrammatic("962"))
    }

    @Test
    fun `middle six must rotate to nine`() {
        assertFalse(Solution().isStrobogrammatic("6"))
        assertTrue(Solution().isStrobogrammatic("8"))
    }
}
